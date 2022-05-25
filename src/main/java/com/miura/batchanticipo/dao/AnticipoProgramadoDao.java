package com.miura.batchanticipo.dao;

import com.miura.batchanticipo.config.DataSourceConfig;
import com.miura.batchanticipo.exception.BusinessException;
import com.miura.batchanticipo.model.AnticipoProgramado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnticipoProgramadoDao {

    Logger LOGGER = LoggerFactory.getLogger(AnticipoProgramadoDao.class);

    @Autowired
    private DataSourceConfig dataSourceConfig;



    public List<AnticipoProgramado> getAnticiposProgramadosToday() throws BusinessException {
        DataSource dataSource = dataSourceConfig.getDataSource();
        String query = "call PROGRAMAR_ANTICIPO_GET_ALL_TODAY();";
        try(Connection con = dataSource.getConnection(); CallableStatement cStmt = con.prepareCall(query)) {

            cStmt.execute();
            List<AnticipoProgramado> anticipoProgramados = new ArrayList<>();
            ResultSet rs = cStmt.getResultSet();
            while(rs.next()) {
            anticipoProgramados.add(crearAnticipoProgramado(rs));
            }
            return anticipoProgramados;
        }catch (SQLException e){
            LOGGER.error("Error actualizando la contraseña: "+e.getMessage(),e);
            throw new BusinessException("Error actualizando la contraseña : "+e.getMessage(),500);
        }
    }


    public void postAnticipoProgramadoErrores(int idAnticipoProgramado, String error, String detalles) throws BusinessException {
        DataSource dataSource = dataSourceConfig.getDataSource();
        String query = "call PROGRAMAR_ANTICIPO_LOG_ERROR(?,?,?);";
        try(Connection con = dataSource.getConnection(); CallableStatement cStmt = con.prepareCall(query)) {

            cStmt.setInt(1,idAnticipoProgramado);
            cStmt.setString(2,error);
            cStmt.setString(3,detalles);

            cStmt.execute();


        }catch (SQLException e){
            LOGGER.error("Error actualizando la contraseña: "+e.getMessage(),e);
            throw new BusinessException("Error actualizando la contraseña : "+e.getMessage(),500);
        }
    }

    public void setNextAnticipoProgramado(int idAnticipoProgramado, int idColaborador, Date next ) throws BusinessException {
        DataSource dataSource = dataSourceConfig.getDataSource();
        String query = "call PROGRAMAR_ANTICIPO_NEXT(?,?,?);";
        try(Connection con = dataSource.getConnection(); CallableStatement cStmt = con.prepareCall(query)) {

            cStmt.setDate(1,new java.sql.Date(next.getTime()));
            cStmt.setInt(2,idAnticipoProgramado);
            cStmt.setInt(3,idColaborador);

            cStmt.execute();

        }catch (SQLException e){
            LOGGER.error("Error actualizando la contraseña: "+e.getMessage(),e);
            throw new BusinessException("Error actualizando la contraseña : "+e.getMessage(),500);
        }
    }

    private AnticipoProgramado crearAnticipoProgramado(ResultSet rs) throws SQLException {
        AnticipoProgramado anticipoProgramado = new AnticipoProgramado();
        anticipoProgramado.setIdProgramacionAnticipo(rs.getInt("programacion_anticipo_id"));
        anticipoProgramado.setFechaAnticipo(rs.getDate("primer_fecha_programada"));
        anticipoProgramado.setFechaSiguienteAnticipo(rs.getDate("siguiente_fecha_programada"));
        anticipoProgramado.setMonto(rs.getDouble("monto"));
        anticipoProgramado.setErrores(rs.getInt("errores"));
        anticipoProgramado.setFechaCreacion(rs.getDate("fecha_creacion"));
        anticipoProgramado.setPeriodo(rs.getInt("periodo"));
        anticipoProgramado.setColaborador(rs.getInt("clave_colaborador"));
        return anticipoProgramado;
    }

}
