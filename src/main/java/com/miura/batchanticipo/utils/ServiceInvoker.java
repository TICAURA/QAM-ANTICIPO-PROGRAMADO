package com.miura.batchanticipo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

@Service
public class ServiceInvoker {
    Logger logger = LoggerFactory.getLogger(ServiceInvoker.class);
    String serviceResponse = null;
    public String invoke(Properties serviceProperties, String body){
    //public String invoke(String endpoint, String body){

        String endpoint = (String) serviceProperties.get("endpoint");
        String http_method = (String) serviceProperties.get("http_method");
        String http_Content_Type = (String) serviceProperties.get("http_Content_Type");
        String http_Accept = (String) serviceProperties.get("http_Accept");
        //String authorization = (String) serviceProperties.get("Authorization");

        //String http_method = "POST";
        //String http_Content_Type = "application/json";
        //String http_Accept = "application/json";

        try {
            logger.info("body:" + body);
            logger.info("Endpoint:" + endpoint);
            URL url = new URL(endpoint);
            //HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            logger.info("Apertura de Conexion HTTPs OK");

            con.setRequestMethod(http_method);
            con.setRequestProperty("Content-Type", http_Content_Type);
            con.setRequestProperty("Accept", http_Accept);
            //con.setRequestProperty("Authorization", authorization);
            con.setDoOutput(true);

            String jsonInputString = body;
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
                logger.info("Envio de datos completado");
            }
            catch (Exception ei){
                logger.error("Se produjo un error de envio/escritura de body:" + ei.getMessage());
                ei.printStackTrace();
            }

            InputStream inputStream = null;
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK)  {
                logger.info("Respuesta completada HTTP OK [" + status +"]");
                inputStream = con.getErrorStream();
            }
            else{
                logger.error("Respuesta HTTP KO [" + status +"]");
                inputStream = con.getInputStream();
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(inputStream, "utf-8"));

            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.info("Recepcion de Datos de Response OK");
            serviceResponse = response.toString();
            logger.info("serviceResponse:" + serviceResponse);
        }
        catch (Exception e){
            logger.error("Se produjo un error en la invocacion:" + e.getMessage());
            e.printStackTrace();
        }
        return serviceResponse;
    }

    public String invokeHTTPS(Properties serviceProperties, String body){
        //public String invoke(String endpoint, String body){

        String endpoint = (String) serviceProperties.get("endpoint");
        String http_method = (String) serviceProperties.get("http_method");
        String http_Content_Type = (String) serviceProperties.get("http_Content_Type");
        String http_Accept = (String) serviceProperties.get("http_Accept");
        String authorization = (String) serviceProperties.get("Authorization");

        //String http_method = "POST";
        //String http_Content_Type = "application/json";
        //String http_Accept = "application/json";

        try {
            logger.info("body:" + body);
            logger.info("Endpoint:" + endpoint);
            URL url = new URL(endpoint);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            logger.info("Apertura de Conexion HTTPs OK");

            con.setRequestMethod(http_method);
            con.setRequestProperty("Content-Type", http_Content_Type);
            con.setRequestProperty("Accept", http_Accept);
            if(authorization != null && !authorization.equals("") ) {
                con.setRequestProperty("Authorization", authorization);
            }
            con.setDoOutput(true);

            String jsonInputString = body;
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
                logger.info("Envio de datos completado");
            }
            catch (Exception ei){
                logger.error("Se produjo un error de envio/escritura de body:" + ei.getMessage());
                ei.printStackTrace();
            }

            InputStream inputStream = null;
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK)  {
                logger.info("Respuesta completada HTTP OK [" + status +"]");
                inputStream = con.getErrorStream();
            }
            else{
                logger.error("Respuesta HTTP KO [" + status +"]");
                inputStream = con.getInputStream();
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(inputStream, "utf-8"));

            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.info("Recepcion de Datos de Response OK");
            serviceResponse = response.toString();
            logger.info("serviceResponse:" + serviceResponse);
        }
        catch (Exception e){
            logger.error("Se produjo un error en la invocacion:" + e.getMessage());
            e.printStackTrace();
        }
        return serviceResponse;
    }

    public String invokeHTTP(Properties serviceProperties){
        //public String invoke(String endpoint, String body){

        String endpoint = (String) serviceProperties.get("endpoint");
        String http_method = (String) serviceProperties.get("http_method");
        String http_Content_Type = (String) serviceProperties.get("http_Content_Type");
        String http_Accept = (String) serviceProperties.get("http_Accept");
        String authorization = (String) serviceProperties.get("Authorization");

        //String http_method = "POST";
        //String http_Content_Type = "application/json";
        //String http_Accept = "application/json";

        try {

            logger.info("Endpoint:" + endpoint);
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            logger.info("Apertura de Conexion HTTPs OK");

            con.setRequestMethod(http_method);
            con.setRequestProperty("Content-Type", http_Content_Type);
            con.setRequestProperty("Accept", http_Accept);
            if(authorization != null && !authorization.equals("") ) {
                con.setRequestProperty("Authorization", authorization);
            }


            InputStream inputStream = null;
            int status = con.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK)  {
                logger.info("Respuesta completada HTTP OK [" + status +"]");
                inputStream = con.getErrorStream();
            }
            else{
                logger.error("Respuesta HTTP KO [" + status +"]");
                inputStream = con.getInputStream();
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(inputStream, "utf-8"));

            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.info("Recepcion de Datos de Response OK");
            serviceResponse = response.toString();
            logger.info("serviceResponse:" + serviceResponse);
        }
        catch (Exception e){
            logger.error("Se produjo un error en la invocacion:" + e.getMessage());
            e.printStackTrace();
        }
        return serviceResponse;
    }

}
