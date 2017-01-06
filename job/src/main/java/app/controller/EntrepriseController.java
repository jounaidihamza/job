package app.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import app.model.Entreprise;
import app.repository.EntrepriseRepository;
import app.service.EntrepriseService;

@Controller
public class EntrepriseController {
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	@Autowired
	EntrepriseService entrepriseService;


	
	@RequestMapping(value="/createentreprise", method = RequestMethod.POST)
	  public @ResponseBody ModelAndView  createUser(Entreprise entreprise, Model model, HttpSession session) {
		   		    
		    Map<String, Object> response = new LinkedHashMap<String, Object>();
		    response.put("message", "entreprise created successfully");
		    response.put("jobSeeker", entrepriseRepository.save(entreprise));
		    session.setAttribute("loggedentreprise", entreprise);
		    model.addAttribute("entrepriseinfo", entreprise);
		    return new ModelAndView("redirect:/allJobSeeker");
	  }

	  @RequestMapping(method = RequestMethod.POST, value="/loginEntreprise")
	  public String verifyLogin(@RequestParam String entrepriseLogin, @RequestParam String password, HttpSession session, Model model){
		  
		  Entreprise entreprise = entrepriseService.loginEntreprise(entrepriseLogin, password);
		  if(entreprise == null){
			  model.addAttribute("loginerror", "Failed to login, Please try again");
			  return "index";
		  }else{
			  model.addAttribute("entrepriseInfo", entreprise);
			  session.setAttribute("loggedentreprise", entreprise);
			  return "redirect:allJobSeeker";
		  }		  
	  }
}
