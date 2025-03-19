package com.jobApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobApp.Dto.Job;
import com.jobApp.service.JobService;

@RestController

public class JobController {

	
	JobService jobService;
	public JobController(@Autowired JobService jobService) {
		this.jobService = jobService;
	}
	
	@GetMapping("/jobs")
	public List<Job> findaAll()
	{
		return jobService.findAll();
	}

	@PostMapping("/jobs")
	public String createJob(@RequestBody Job job)
	{
		boolean f=jobService.addJob(job);
		if(f) return "Succesfully added";
		else return "Not added";
		
	}
	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getById(@PathVariable Long id) {
		Job job=jobService.getById(id);
		if (job == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(job);
		}
	}
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		if (jobService.deleteById(id)) {
			return ResponseEntity.ok().body("Job deleted with success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Job job) {
		if (jobService.updateById(id, job)) {
			return ResponseEntity.ok().body("Job updated with success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
