package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Messages;
import app.repository.MessagesRepository;

@Service
public class MessagesService {

	@Autowired
	private MessagesRepository messagesRepository;
	
public List<Messages> byIdJobSeeker(String idJobSeeker){
		
		return messagesRepository.findByIdJobSeeker(idJobSeeker);
		
	}
}
