package kodu.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import kodu.controllers.support.ControllerUtils;
import kodu.model.mongo.User;
import kodu.services.AccountConfigurationService;
import kodu.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/profileConfiguration")
public class ProfileConfigurationController {

	@Autowired
	AccountConfigurationService accountService;

	@Autowired
	SessionService sessionService;

	@RequestMapping(method = RequestMethod.GET)
	public String profileConfiguration(Principal principal, Model model) {
		User user = sessionService.getCurrentUser(principal);
		model.addAttribute("user", user);
		return "profileConfiguration";
	}

	@RequestMapping(value = "photo", method = RequestMethod.POST)
	public String doUpdateProfilePhoto(Principal principal,
			@RequestParam MultipartFile file) {
		try {
			String username = ControllerUtils.getCurrentUsername(principal);
			accountService.updateProfilePhoto(username,
					file.getOriginalFilename(), file.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/profileConfiguration";
	}

	@RequestMapping(method = RequestMethod.POST, params = { "localization",
			"languages" })
	public String configureInformation(@RequestParam String localization,
			@RequestParam String languages, Principal principal) {
		User user = sessionService.getCurrentUser(principal);
		String loc = user.getLocatedOn();
		List<String> lan = user.getLanguages();
				
		String[] language = languages.split(" ");
		List<String> lang = new ArrayList<String>();
		for (int i = 0; i < language.length; i++) {
			lang.add(language[i]);
		}
		
		System.out.println("lenguajes ingresados " + lang);
		if(!lang.isEmpty()){
			for (int i = 0; i<lang.size();i++){
				String temp = lang.get(i);
				lan.add(temp);
			}
		}
		
		if(!localization.equals("")){
			loc = localization;
		}
		System.out.println("localizacion a insertar "+loc);
		System.out.println("lenguajes a insertar " + lan);
		accountService.editInformation(user.getId(), loc, lan);
		return "redirect:/profileConfiguration";
	}

	@RequestMapping(method = RequestMethod.POST, params = { "current",
			"newPassword", "confirm" })
	public String configureEditPassword(@RequestParam String current,
			@RequestParam String newPassword, @RequestParam String confirm,
			Principal principal) {
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