package com.miura.batchanticipo.config;

import com.miura.batchanticipo.batch.*;
import com.miura.batchanticipo.model.AnticipoProgramado;
import com.miura.batchanticipo.model.ImporteAnticipo;
import com.miura.batchanticipo.model.SolicitudAnticipo;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

    @Override
    public void setDataSource(DataSource dataSource) {
        // override to do not set datasource even if a datasource exist.
        // initialize will use a Map based JobRepository (instead of database)
    }

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Reader reader;

    @Autowired
    private Processor processor;

    @Autowired
    private Writer writer;


    @Bean
    public Job processJob() {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer()).listener(listener())
                .flow(orderStep1()).end().build();
    }

    @Bean
    public Step orderStep1() {
        return stepBuilderFactory.get("orderStep1").<AnticipoProgramado, SolicitudAnticipo> chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener((ItemProcessListener<? super ImporteAnticipo, ? super ImporteAnticipo>) new ItemFailureLoggerListener())
                .build();
    }



    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionListener();
    }



}