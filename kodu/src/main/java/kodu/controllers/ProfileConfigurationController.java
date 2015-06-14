package kodu.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import kodu.model.mongo.Post;
import kodu.model.mongo.User;
import kodu.services.AccountConfigurationService;
import kodu.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profileConfiguration")
public class ProfileConfigurationController {

	@Autowired
	AccountConfigurationService accountService;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method=RequestMethod.GET)
	public String profileConfiguration( Principal principal,Model model) {	
		User user = sessionService.getCurrentUser(principal);
		model.addAttribute("user", user);
		return "profileConfiguration";	
	}

	@RequestMapping(method = RequestMethod.POST, params={"localization", "languages"})
	public String configureInformation(@RequestParam String localization, @RequestParam String languages , Principal principal) {
		User user = sessionService.getCurrentUser(principal);
		//String[] language = languages.split(" ");
		List<String> lang = new ArrayList<String>();
		//for (int i = 0; i < language.length; i++) {
		//	lang.add(language[i]);
		//}
		lang.add(languages);
		accountService.editInformation(user.getId(), localization, lang);
		return "redirect:/profileConfiguration";
	}

	@RequestMapping(method = RequestMethod.POST, params={"current", "newPassword", "confirm"})
	public String configureEditPassword(@RequestParam String current,
			@RequestParam String newPassword,
			@RequestParam String confirm, Principal principal) {
		User user = sessionService.getCurrentUser(principal);
		
		if (newPassword.equals(confirm) && current.equals(user.getPassword())) {
			accountService.editPassword(user.getId(), newPassword, confirm);
		} 
		
		else {
			System.out.println("Las contraseñas no coinciden");
			return ("redirect:/?passwordMismatch");
		}
		
		return "redirect:/profileConfiguration";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String deleteAccount(Principal principal) {
		User user = sessionService.getCurrentUser(principal);
		accountService.deleteAccount(user.getId());
		return "redirect:/login";
	}
	
	 
}