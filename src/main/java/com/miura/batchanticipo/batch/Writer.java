package com.miura.batchanticipo.batch;

import com.miura.batchanticipo.model.ImporteAnticipo;
import com.miura.batchanticipo.model.SolicitudAnticipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<SolicitudAnticipo> {

    Logger logger = LoggerFactory.getLogger(Processor.class);
    @Override
    public void write(List<? extends SolicitudAnticipo> messages) throws Exception {

    }

}
