package app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.model.Entreprise;
import app.model.Messages;
import app.repository.MessagesRepository;
import app.service.MessagesService;

@Controller
public class MessagesController {
	
	@Autowired
	private MessagesRepository messagesRepository;
	
	@Autowired
	private MessagesService messagesService;
	
	@RequestMapping(value="/sendmessage", method = RequestMethod.POST)
	  public @ResponseBody ModelAndView  createUser(Messages message, HttpSession session) {
		   		    
		    Map<String, Object> response = new LinkedHashMap<String, Object>();
			Entreprise entreprise= (Entreprise) session.getAttribute("loggedentreprise");
			message.setIdEntreprise(entreprise.getId());
		    response.put("message", "message added successfully");
		    response.put("messages", messagesRepository.save(message));
		    return new ModelAndView("redirect:/jobSeekerInfo/"+message.getIdJobSeeker());
	  }
	
//	@RequestMapping(value="jobSeekerInfo/{idJobSeeker}", method = RequestMethod.GET)
//	  public String getUser(Model model, @PathVariable String idJobSeeker){
//		 
//		    model.addAttribute("jobSeekermsgs", messagesService.byIdJobSeeker(idJobSeeker));
//
//		    return "jobSeekerInfo/"+idJobSeeker;
//		  }

}
