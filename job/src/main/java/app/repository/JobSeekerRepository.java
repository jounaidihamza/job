package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.JobSeeker;

public interface JobSeekerRepository extends MongoRepository<JobSeeker,String>{
	public JobSeeker findByEmailAndPassword(String username,String password);
}
