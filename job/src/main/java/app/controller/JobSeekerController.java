package app.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.model.Entreprise;
import app.model.JobSeeker;
import app.repository.JobSeekerRepository;
import app.service.JobSeekerService;
import app.service.MessagesService;

@Controller
public class JobSeekerController {
	
	@Autowired
	JobSeekerRepository jobSeekerRepository;
	
	@Autowired
	JobSeekerService jobSeekerService;
	
	@Autowired
	private MessagesService messagesService;
	
	@RequestMapping("/")
	 String index(){
		 return "index";
	 }
	
	@RequestMapping(value="/createuser", method = RequestMethod.POST)
	  public @ResponseBody ModelAndView  createUser(JobSeeker jobSeeker, Model model, HttpSession session) {
		   		    
		    Map<String, Object> response = new LinkedHashMap<String, Object>();
		    response.put("message", "User created successfully");
		    response.put("jobSeeker", jobSeekerRepository.save(jobSeeker));
		    session.setAttribute("loggeduser", jobSeeker);
		    model.addAttribute("jobSeekerInfo", jobSeeker);
		    return new ModelAndView("redirect:/jobSeekerInfo/"+jobSeeker.getId());
	  }
	
	@RequestMapping(method = RequestMethod.POST, value="/loginJobSeeker")
	  public String verifyLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model){
		  
		  JobSeeker jobSeeker = jobSeekerService.loginJobSeeker(email, password);
		  if(jobSeeker == null){
			  model.addAttribute("loginerror", "Failed to login, Please try again");
			  return "index";
		  }else{
			  model.addAttribute("jobSeekerInfo", jobSeeker);
			  session.setAttribute("loggeduser", jobSeeker);
			  return "redirect:jobSeekerInfo/"+jobSeeker.getId();
		  }		  
	  }
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	  public JobSeeker getUserDetails(@PathVariable("id") String id){
	    return jobSeekerRepository.findOne(id);
	  }
	
	@RequestMapping(value="allJobSeeker")
	  public String getAllJobSeekers(Model model){
	    List<JobSeeker> storedJobSeekers = jobSeekerRepository.findAll();
	    model.addAttribute("jobSeekersList", storedJobSeekers);

	    return "allJobSeeker";
	  }
	
	@RequestMapping(value="jobSeekerInfo/{id}", method = RequestMethod.GET)
	  public String getUser(Model model, @PathVariable String id){
		 
		    model.addAttribute("jobSeekerInfo", jobSeekerRepository.findOne(id));
		    model.addAttribute("jobSeekerMsgs", messagesService.byIdJobSeeker(id));

		    return "jobSeekerInfo";
	  }
}
