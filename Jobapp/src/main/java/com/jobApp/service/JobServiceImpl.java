package com.jobApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jobApp.Dto.Job;

@Service
public class JobServiceImpl implements JobService {
	List<Job> jobs=new ArrayList<>();
	Long id=1L;
	public JobServiceImpl() {
        Job newjob = new Job(id,"Software Engineer","Developing Software","50000","100000","Bangalore");
        jobs.add(newjob);
        id++;
    }
	public List<Job> findAll() {
	
		return jobs;
	}

	public boolean addJob(Job job) {
		job.setId(id);
		id++;
		jobs.add(job);
	 return true;
	
	}

	public Job getById(Long id) {
		for(Job job:jobs) {
			if(job.getId()==id) return job;
		}
			return null;
		
	}
	@Override
	public boolean deleteById(Long id) {
	  for(Job job:jobs)
	  {
		  if(job.getId()==id) {
			  jobs.remove(job);
			  return true;
		  }
	  }
	  return false;
	}
	@Override
	public boolean updateById(Long id, Job job) {
		for (Job j : jobs) {
			if (j.getId() == id) {
				j.setTitle(job.getTitle());
				j.setDescription(job.getDescription());
				j.setMinSalary(job.getMinSalary());
				j.setMaxSalary(job.getMaxSalary());
				j.setLocation(job.getLocation());
				return true;
			}
		}
		return false;
	}

}
