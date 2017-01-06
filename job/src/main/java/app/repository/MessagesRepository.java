package app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Messages;

public interface MessagesRepository extends MongoRepository<Messages, String> {

	List<Messages> findByIdJobSeeker(String idJobSeeker);

}
