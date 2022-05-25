package com.miura.batchanticipo.batch;

import com.miura.batchanticipo.dao.AnticipoProgramadoDao;
import com.miura.batchanticipo.model.AnticipoProgramado;
import com.miura.batchanticipo.model.ImporteAnticipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Reader implements ItemReader<AnticipoProgramado>  {

    @Autowired
    private AnticipoProgramadoDao anticipoProgramadoDao;

    List<AnticipoProgramado> anticipoProgramadoList;

    private int count = 0;

    private boolean load = true;

    Logger logger = LoggerFactory.getLogger(Processor.class);

    @Override
    public AnticipoProgramado read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {
        logger.info("READER");
        if(load){
            load = false;
            anticipoProgramadoList = anticipoProgramadoDao.getAnticiposProgramadosToday();
            count = anticipoProgramadoList.size()-1;
        }

        if(count>=0){
            AnticipoProgramado anticipoProgramado = anticipoProgramadoList.get(count);
            count--;
            return anticipoProgramado;
        }

        return null;
    }

}
