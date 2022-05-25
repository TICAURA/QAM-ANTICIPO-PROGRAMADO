package com.miura.batchanticipo.batch;

import com.miura.batchanticipo.model.ImporteAnticipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.listener.ItemListenerSupport;

import java.util.List;

public class ItemFailureLoggerListener extends ItemListenerSupport< ImporteAnticipo, ImporteAnticipo> {


    Logger logger = LoggerFactory.getLogger(ItemFailureLoggerListener.class);

    public void onReadError(Exception ex) {
        logger.error(ex.getMessage());
    }

    public void onProcessError(ImporteAnticipo item, Exception e) {
        logger.error(e.getMessage());
    }

    public void onWriteError(Exception ex, List<? extends ImporteAnticipo> items) {
        logger.error(ex.getMessage());
    }

}