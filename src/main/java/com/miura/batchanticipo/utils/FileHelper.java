package com.miura.batchanticipo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileHelper {
    Logger logger = LoggerFactory.getLogger(FileHelper.class);

    public String readFile(String fileName){
        String contentFile = null;
        StringBuilder sb = new StringBuilder();
        String userDirectory = new File("").getAbsolutePath();
        String filePath = userDirectory + "/" + fileName;

        try (InputStream inputStream = new FileInputStream(filePath)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.lineSeparator());
            }
            /**dbProperties.load(inputStream);
            for (Object execProperty : dbProperties.keySet()) {
                logger.info("Propiedad de " + propsReference + " [" + execProperty + "] [" +
                        dbProperties.get(execProperty).toString() + "]");
            }*/
        } catch (FileNotFoundException fnfe) {
            logger.error("No se encontro el archivo: " + fnfe.getMessage());
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            logger.error("Se produjo un error de lectura de archivo: " + ioe.getMessage());
            ioe.getMessage();
        }

        contentFile = sb.toString();

        return contentFile;
    }
}
