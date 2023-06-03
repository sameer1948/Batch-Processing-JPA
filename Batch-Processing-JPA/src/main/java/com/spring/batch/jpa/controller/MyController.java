package com.spring.batch.jpa.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/batch/")
public class MyController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@PostMapping("invoke")
	public String runMyJob() {
		
		JobParameters jobParameters = new JobParametersBuilder().addLong("Started At",System.currentTimeMillis()).toJobParameters();
		
		try {
			jobLauncher.run(job, jobParameters);
			
		} catch (JobExecutionAlreadyRunningException e) {
		 
			e.printStackTrace();
		} catch (JobRestartException e) {
		 
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
		 
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
		 
			e.printStackTrace();
		}
		
		return "Done...!";
	}
	

}