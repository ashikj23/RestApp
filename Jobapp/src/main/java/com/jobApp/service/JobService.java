package com.jobApp.service;

import java.util.List;

import com.jobApp.Dto.Job;

public interface JobService {

	List<Job> findAll();

	boolean addJob(Job job);

	Job getById(Long id);

	boolean deleteById(Long id);

	boolean updateById(Long id, Job job);
	
}
