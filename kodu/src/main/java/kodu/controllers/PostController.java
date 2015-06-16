package kodu.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping({"/home","/profile/{username}"})

public class PostController {
	
	@Autowired
	UserFunctionsService ufservice;
	@Autowired
	SessionService sessionService;
	@Autowired
	VisualizationService visualizationService;
	   
	@RequestMapping(method= RequestMethod.POST,params={"descripcion","codigo"})
	public String doPublish(@RequestParam String descripcion, @RequestParam String codigo,Principal principal, HttpServletRequest request){
		User user = sessionService.getCurrentUser(principal);
		ufservice.publish(user.getId(), descripcion, codigo, null);
		return "redirect:"+request.getServletPath();
		
	}
	
	@RequestMapping(method= RequestMethod.POST,params={"postId","commentContent"})
	public String doComment(@RequestParam String commentContent,@RequestParam String postId,Principal principal,HttpServletRequest request){
		User commenter = sessionService.getCurrentUser(principal);
		System.out.println(commenter.getUsername()+" desea comentar: "+commentContent+" en el post: "+postId);
		ufservice.commentPublication(postId,commenter.getUsername(), commentContent);
		return "redirect:"+request.getServletPath();		
	}

	@RequestMapping(method= RequestMethod.POST,params={"shareDescription","postId"})
	public String doShare(@RequestParam String shareDescription,@RequestParam String postId,Principal principal,HttpServletRequest request){
		User sharer = sessionService.getCurrentUser(principal);
		ufservice.share(sharer.getUsername(), postId,shareDescription);
		return "redirect:"+request.getServletPath();
	}	

	
	

}
