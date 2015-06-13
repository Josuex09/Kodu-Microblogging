package kodu.controllers;


import kodu.model.mongo.User;
import kodu.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LogInController {
	
	 @Autowired
	    private SessionService sessionService ;
	 @RequestMapping(method = RequestMethod.GET)
	    public String show() {
		 
		 return "login";
	    }
	    

	    
	    @RequestMapping(method = RequestMethod.POST)
	    public String doSignup(@RequestParam String username,
	    					   @RequestParam String email,
	                           @RequestParam String password,
	                           @RequestParam String confirm) {

	        if (!password.equals(confirm)) {
	        	System.out.println("contraseña diferente");
	            return "redirect:/?passwordMismatch";
	        }
	        User newUser = sessionService.signUp(username, email, password, confirm);

	        if (newUser == null) {
	            return "redirect:/?usernameAlreadyExists";
	        } else { 
	            return "forward:/home";
	            
	        }
	    }

}
