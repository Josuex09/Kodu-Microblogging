package kodu.controllers;

import java.security.Principal;

import kodu.model.mongo.User;
import kodu.services.SessionService;
import kodu.services.UserFunctionsService;
import kodu.services.VisualizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	UserFunctionsService ufservice;
	@Autowired
	SessionService sessionService;
	@Autowired
	VisualizationService vservice;
	
	@RequestMapping(method= RequestMethod.POST,params={"descripcion","codigo"})
	public String doPublish(@RequestParam String descripcion, @RequestParam String codigo,Principal principal){
		User user = sessionService.getCurrentUser(principal);
		ufservice.publish(user.getId(), descripcion, codigo, null);
		return "redirect:/home";
		
	}
	
	@RequestMapping(method= RequestMethod.POST,params={"postId","commentContent"})
	public String doComment(@RequestParam String commentContent,@RequestParam String postId,Principal principal){
		User commenter = sessionService.getCurrentUser(principal);
		System.out.println(commenter.getUsername()+" desea comentar: "+commentContent+" en el post: "+postId);
		ufservice.commentPublication(postId,commenter.getUsername(), commentContent);
		return "redirect:/home";		
	}

	

	
	

}
