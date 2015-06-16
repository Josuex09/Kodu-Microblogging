package kodu.controllers;

import kodu.model.mongo.User;
import kodu.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private SessionService sessionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String show() {
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doSignup(@RequestParam String username,
			@RequestParam String email, @RequestParam String password,
			@RequestParam String confirm) {
		System.out.println("se desea crear el usuario: "+username+" "+email+" "+password+" "+confirm);
		if (!password.equals(confirm)) {
			System.out.println("contraseña diferente");
			return "redirect:/signup?passwordMismatch";
		}
		
		User newUser = sessionService.signUp(username, email, password, confirm);

		if (newUser == null) {
			return "redirect:/signup?usernameAlreadyExists";
		} else {
			return "login";

		}
	}

}
