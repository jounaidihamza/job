package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.JobSeeker;
import app.repository.JobSeekerRepository;

@Service
public class JobSeekerService {
	
	JobSeekerRepository jobSeekerRepository;

	@Autowired
	public void setJobSeekerRepository(JobSeekerRepository jobSeekerRepository) {
		this.jobSeekerRepository = jobSeekerRepository;
	}

	public JobSeeker loginJobSeeker(String email,String password){
		
		return jobSeekerRepository.findByEmailAndPassword(email, password);
		
	}
}
