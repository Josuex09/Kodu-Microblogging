package kodu.controllers;

import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kodu.model.mongo.Post;
import kodu.model.mongo.User;
import kodu.services.SessionService;
import kodu.services.UserFunctionsService;
import kodu.services.VisualizationService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	VisualizationService visualizationService;

	@Autowired
	SessionService sessionService;

	@Autowired
	UserFunctionsService userFunctionsService;
	
	
	
	@RequestMapping(value = { "/{username}"},params={"follow"},method=RequestMethod.POST)
	public String follow(@RequestParam String follow,Principal principal,@PathVariable String username){
		User u = sessionService.getCurrentUser(principal);
		userFunctionsService.follow(u.getUsername(),username);
		return "redirect:/profile/"+username;
	}

	@RequestMapping(value = { "/{username}"},params={"stopFollowing"},method=RequestMethod.POST)
	public String stopFollowing(@RequestParam String stopFollowing,Principal principal,@PathVariable String username){
		User u = sessionService.getCurrentUser(principal);
		userFunctionsService.stopFollowing(u.getUsername(),username);
		return "redirect:/profile/"+username;
	}
	@RequestMapping(value = "/photo", method = RequestMethod.GET)
	public void showProfilePhoto(HttpServletResponse response,
			@RequestParam String username) {
		try {
			InputStream photo = visualizationService
					.showUserProfilePhoto(username);
			System.out.println(photo == null);
			if (photo != null) {
				IOUtils.copy(photo, response.getOutputStream());
			} else {
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			}
		} catch (Exception e) {
			System.out.println("exception");
		}
	}


}
