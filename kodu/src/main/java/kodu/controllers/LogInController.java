package kodu.controllers;

import kodu.services.SessionService;
import kodu.services.UserFunctionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LogInController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private UserFunctionsService ufservice;

	@RequestMapping(method = RequestMethod.GET)
	public String show() {
		return "login";
		
	}

}
