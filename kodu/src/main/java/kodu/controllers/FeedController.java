package kodu.controllers;

import java.security.Principal;

import kodu.model.mongo.User;
import kodu.services.SessionService;
import kodu.services.UserFunctionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/feed")
public class FeedController {
	
	@Autowired
	UserFunctionsService ufservice;
	@Autowired
	SessionService sessionService;
	
	
	@RequestMapping(method= RequestMethod.POST)
	public String doPublish(@RequestParam String descripcion, @RequestParam String codigo,Principal principal){
		User user = sessionService.getCurrentUser(principal);
		ufservice.publish(user.getId(), descripcion, codigo, null);
		return "redirect:/feed";
		
	}
	
	

}
