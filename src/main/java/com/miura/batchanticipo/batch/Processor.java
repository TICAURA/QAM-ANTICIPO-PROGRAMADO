package com.miura.batchanticipo.batch;

import com.miura.batchanticipo.dao.AnticipoProgramadoDao;
import com.miura.batchanticipo.dao.QuincenaDAO;
import com.miura.batchanticipo.exception.BusinessException;
import com.miura.batchanticipo.model.AnticipoProgramado;
import com.miura.batchanticipo.model.Colaborador;
import com.miura.batchanticipo.model.ImporteAnticipo;
import com.miura.batchanticipo.model.SolicitudAnticipo;
import com.miura.batchanticipo.service.DispersorService;
import com.miura.batchanticipo.transformer.QuincenaTransformer;
import com.miura.batchanticipo.utils.PeriodoENUM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Component
public class Processor implements ItemProcessor<AnticipoProgramado, SolicitudAnticipo> {
    @Autowired
            private AnticipoProgramadoDao anticipoProgramadoDao;
    @Autowired
            private QuincenaDAO quincenaDAO;
    @Autowired
            private DispersorService dispersorService;

    private int DAY = 24*60*60*1000;

    Logger logger = LoggerFactory.getLogger(Processor.class);
    @Override
    public SolicitudAnticipo process(AnticipoProgramado data) throws Exception {

        //se obtiene importe y comisión
        ImporteAnticipo importeAnticipo = QuincenaTransformer.transformComisionAnticipo(quincenaDAO.consultaComisionAnticipo(data.getColaborador(),data.getMonto()));
        importeAnticipo.setImporteSolicitado(data.getMonto()+"");
        importeAnticipo.setIdColaborador(data.getColaborador());

        //Se obtiene saldo.
        String dbJson = quincenaDAO.consultaSaldo(data.getColaborador());
        Colaborador colaborador = QuincenaTransformer.transformConsultaSaldo(dbJson);

        //Se valida si el usuario tiene suficiente saldo.
        if(Double.parseDouble(colaborador.getMontoDisponible())<Double.parseDouble(importeAnticipo.getImporteSolicitado())){
            anticipoProgramadoDao.postAnticipoProgramadoErrores(data.getIdProgramacionAnticipo(),"SALDO_INSUFICIENTE","El usuario no tiene los fondos necesarios para la transacción, SALDO DISPONIBLE: "+colaborador.getMontoDisponible()+" MONTO SOLICITADO: "+data.getMonto());
            throw new BusinessException("SALDO_INSUFICIENTE",0);
        }
        SolicitudAnticipo solicitudAnticipo;
        try {
            //Se hace la disperción
            solicitudAnticipo = dispersorService.dispersar(importeAnticipo);
        }catch (Exception e){
            anticipoProgramadoDao.postAnticipoProgramadoErrores(data.getIdProgramacionAnticipo(),"ERROR INESPERADO",e.getMessage());
            throw e;
        }
        Date siguienteAnticipo ;
        //calcular siguiente anticipo
        if(data.getPeriodo()== PeriodoENUM.SEMANAL.getId()){
          siguienteAnticipo = new Date(data.getFechaSiguienteAnticipo().getTime() + 7*DAY);
        }   else if (data.getPeriodo()== PeriodoENUM.QUINCENAL.getId()){
            siguienteAnticipo = new Date(data.getFechaSiguienteAnticipo().getTime() + 15*DAY);
        }   else if(data.getPeriodo()==PeriodoENUM.MENSUAL.getId()){

            //FECHA actual con 1 mes más
            siguienteAnticipo = siguienteFechaMes(data.getFechaAnticipo());

        } else{
            siguienteAnticipo = data.getFechaSiguienteAnticipo();
        }

        //Se programa siguiente anticipo.
        anticipoProgramadoDao.setNextAnticipoProgramado(data.getIdProgramacionAnticipo(),data.getColaborador(),siguienteAnticipo);

        return solicitudAnticipo;
    }

    private Date siguienteFechaMes(Date fechaAnticipo){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, 1);
        //ultimo día del siguiente mes (res)
        int res = cal.getActualMaximum(Calendar.DATE);

        //Fecha del primer anticipo
        Calendar cal2 = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        cal2.setTime(fechaAnticipo);


        //Checamos si el próximo mes cuenta con el mismo día de disperción
        if(cal2.get(Calendar.DAY_OF_MONTH)<=res){
            cal.set(Calendar.DAY_OF_MONTH,cal2.get(Calendar.DAY_OF_MONTH));//ponemos el mismo día de disperción que el primer día
            return new Date(cal.getTimeInMillis());
        }else{ //en caso de que el mismo día no pueda ser replicado en el siguiente mes, por ejemplo, dispersar todos los 31, se elije el último día del mes
            cal.set(Calendar.DAY_OF_MONTH,res);
            return new Date(cal.getTimeInMillis());
        }
    }

}
