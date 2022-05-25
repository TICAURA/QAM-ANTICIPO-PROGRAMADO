package com.miura.batchanticipo;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BatchAnticipoApplication  {



	public static void main(String[] args){


		ConfigurableApplicationContext ctx = SpringApplication.run(BatchAnticipoApplication.class, args);

/**
		JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
		Job job = ctx.getBean("processJob", Job.class);

		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Job Status : " + execution.getStatus());
			System.out.println("Job completed");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Job failed");
		}


		ctx.close();
**/
	}



}
