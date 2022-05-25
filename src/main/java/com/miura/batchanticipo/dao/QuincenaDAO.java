package com.miura.batchanticipo.dao;

import com.miura.batchanticipo.config.DataSourceConfig;
import com.miura.batchanticipo.model.ImporteAnticipo;
import com.miura.batchanticipo.model.Pago_STP;
import com.miura.batchanticipo.model.SolicitudAnticipo;
import com.miura.batchanticipo.model.TestResultRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Service
public class QuincenaDAO {
    Logger logger = LoggerFactory.getLogger(QuincenaDAO.class);

    private static final String EXITO_EVENTO = "exito";
    private static final String ERROR_EVENTO = "error";
    
    @Autowired
    private DataSourceConfig dataSourceConfig;

    public String consultaSaldo(Integer idColaborador){
        String resultJSON = null;
        Connection con = null;
        CallableStatement cStmt = null;
        try {
            DataSource dataSource = dataSourceConfig.getDataSource();
            con = dataSource.getConnection();
            //con = DriverManager.getConnection(
                    //"jdbc:mysql://119.8.3.41:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
                    //"jdbc:mysql://94.74.70.240:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
            cStmt = con.prepareCall("{? = call APP_MOBILE_SALDO_ACTUAL(?)}");
            cStmt.registerOutParameter(1, Types.OTHER);
            cStmt.setInt(2, idColaborador);
            cStmt.execute();
            resultJSON = cStmt.getString(1);
            //cStmt.close();
            //cStmt.close();
            logger.info("Consulta Saldo resultJSON:" + resultJSON);
        }
        catch (Exception e){
            logger.error("Excection en DAO Consulta Saldo:" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try { if (cStmt != null) { cStmt.close(); }
            }
            catch (Exception eSt) {
                logger.error("Excepcion en Cierre de Sentencia:" + eSt.getMessage());
            }
            try { if (con != null) { con.close(); }
            }
            catch (Exception eCon) {
                logger.error("Excepcion en Cierre de Conexion:" + eCon.getMessage());
            }
        }
        return resultJSON;
    }

    public String consultaComisionAnticipo(Integer idColaborador, Double importeSolicitado){
        String resultJSON = null;
        Connection con = null;
        CallableStatement cStmt = null;
        try {
            DataSource dataSource = dataSourceConfig.getDataSource();
            con = dataSource.getConnection();
            //con = DriverManager.getConnection(
            //        "jdbc:mysql://119.8.3.41:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
                    //"jdbc:mysql://94.74.70.240:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
            cStmt = con.prepareCall("{? = call APP_MOBILE_COMISION_ANTICIPO(?,?)}");
            cStmt.registerOutParameter(1, Types.OTHER);
            cStmt.setInt(2, idColaborador);
            cStmt.setDouble(3, importeSolicitado);
            cStmt.execute();
            resultJSON = cStmt.getString(1);

            logger.info("Consulta Comision Anticipo resultJSON:" + resultJSON);
        }
        catch (Exception e){
            logger.error("Excection en DAO Comision Anticipo:" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try { if (cStmt != null) { cStmt.close(); }
            }
            catch (Exception eSt) {
                logger.error("Excepcion en Cierre de Sentencia:" + eSt.getMessage());
            }
            try { if (con != null) { con.close(); }
            }
            catch (Exception eCon) {
                logger.error("Excepcion en Cierre de Conexion:" + eCon.getMessage());
            }
        }
        return resultJSON;
    }


    public String confirmaSolitiudAnticipo(ImporteAnticipo importeAnticipo){
        String resultJSON = null;
        Connection con = null;
        CallableStatement cStmt = null;
        try {
            DataSource dataSource = dataSourceConfig.getDataSource();
            con = dataSource.getConnection();
            //con = DriverManager.getConnection(
            //        "jdbc:mysql://119.8.3.41:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
                    //"jdbc:mysql://94.74.70.240:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
            //cStmt = con.prepareCall("{? = call APP_MOBILE_CONFIRMA_SOLICITUD_ANTICIPO_2(?,?,?,?,?,?)}");
            cStmt = con.prepareCall("{? = call APP_MOBILE_CONFIRMA_SOLICITUD_ANTICIPO_2(?,?,?,?)}");
            cStmt.registerOutParameter(1, Types.OTHER);
            cStmt.setInt(2, importeAnticipo.getIdColaborador());
            cStmt.setDouble(3, Double.parseDouble(importeAnticipo.getImporteSolicitado()));
            cStmt.setDouble(4, Double.parseDouble(importeAnticipo.getImporteComision()));
            cStmt.setDouble(5, Double.parseDouble(importeAnticipo.getImporteTotal()));
            cStmt.execute();
            resultJSON = cStmt.getString(1);

            logger.info("Confirma Solitiud Anticipo resultJSON:" + resultJSON);
        }
        catch (Exception e){
            logger.error("Excection en DAO Comision Anticipo:" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try { if (cStmt != null) { cStmt.close(); }
            }
            catch (Exception eSt) {
                logger.error("Excepcion en Cierre de Sentencia:" + eSt.getMessage());
            }
            try { if (con != null) { con.close(); }
            }
            catch (Exception eCon) {
                logger.error("Excepcion en Cierre de Conexion:" + eCon.getMessage());
            }
        }
        return resultJSON;
    }



    public String confirmaSolitiudAnticipoSTP(SolicitudAnticipo solicitudAnticipo, Pago_STP pago_stp){
        String resultJSON = null;
        Connection con = null;
        CallableStatement cStmt = null;
        try {
            DataSource dataSource = dataSourceConfig.getDataSource();
            con = dataSource.getConnection();
            //con = DriverManager.getConnection(
            //        "jdbc:mysql://119.8.3.41:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
                    //"jdbc:mysql://94.74.70.240:3306/quincena_amm", "root", "c0ns0l1daMX_2021");
            cStmt = con.prepareCall("{? = call APP_MOBILE_API_PAGO_SOLICITA_STP(?,?,?,?,?)}");
            cStmt.registerOutParameter(1, Types.OTHER);

            cStmt.setInt(2, Integer.parseInt(solicitudAnticipo.getId_anti()));
            cStmt.setString(3, pago_stp.getCadenaOriginal());
            cStmt.setString(4, pago_stp.getCadenaSellada());
            cStmt.setString(5, solicitudAnticipo.getFolio_origen());
            cStmt.setString(6, pago_stp.getResultadoSTP());

            cStmt.execute();
            resultJSON = cStmt.getString(1);

            logger.info("Confirma Solitiud Anticipo STP resultJSON:" + resultJSON);
        }
        catch (Exception e){
            logger.error("Excection en DAO Comision Anticipo STP:" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try { if (cStmt != null) { cStmt.close(); }
            }
            catch (Exception eSt) {
                logger.error("Excepcion en Cierre de Sentencia:" + eSt.getMessage());
            }
            try { if (con != null) { con.close(); }
            }
            catch (Exception eCon) {
                logger.error("Excepcion en Cierre de Conexion:" + eCon.getMessage());
            }
        }
        return resultJSON;
    }

    public String saveResponse(TestResultRequest testResultRequest){
        String resultJSON = null;

        Connection con = null;
        CallableStatement cStmt = null;
        try {
            DataSource dataSource = dataSourceConfig.getDataSource();
            con = dataSource.getConnection();

            String query="{? = call APP_MOBILE_API_PAGO_RESPUESTA_ASINCRONA_BP(?,?,?,?,?,?)}";

            cStmt = con.prepareCall(query);
            cStmt.registerOutParameter(1, Types.OTHER);
            cStmt.setString(2, testResultRequest.toString());
            cStmt.setString(3, testResultRequest.getId());
            cStmt.setString(4, testResultRequest.getEmpresa());
            cStmt.setString(5, testResultRequest.getFolioOrigen());
            cStmt.setString(6, testResultRequest.getEstado());
            cStmt.setString(7, testResultRequest.getCausaDevolucion());

            cStmt.execute();
            resultJSON = cStmt.getString(1);

            logger.info("Registro Respuesta asyncrona STP resultJSON:" + resultJSON);
        }
        catch (Exception e){
            logger.error("Excection en DAO Consulta Saldo:" + e.getMessage());
            e.printStackTrace();
        }
        finally {
            try { if (cStmt != null) { cStmt.close(); }
            }
            catch (Exception eSt) {
                logger.error("Excepcion en Cierre de Sentencia:" + eSt.getMessage());
            }
            try { if (con != null) { con.close(); }
            }
            catch (Exception eCon) {
                logger.error("Excepcion en Cierre de Conexion:" + eCon.getMessage());
            }
        }

        return resultJSON;
    }
}
