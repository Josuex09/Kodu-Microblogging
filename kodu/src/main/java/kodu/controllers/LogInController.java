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
//<<<<<<< HEAD:kodu/src/main/java/kodu/controllers/SignUpController.java
	 private SessionService sessionService ;
	 @Autowired
//	 FileRepository fr;
	 
	 
	 
//=======
//	    private SessionService sessionService ;
//>>>>>>> 5e04c3931ce20bd072b5991cb3a73d3f0af8eb9f:kodu/src/main/java/kodu/controllers/LogInController.java
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
