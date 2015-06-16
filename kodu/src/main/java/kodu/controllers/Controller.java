package kodu.controllers;

import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kodu.model.mongo.Notification;
import kodu.model.mongo.Post;
import kodu.model.mongo.User;
import kodu.services.AccountConfigurationService;
import kodu.services.SessionService;
import kodu.services.UserFunctionsService;
import kodu.services.VisualizationService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	VisualizationService visualizationService;

	@Autowired
	SessionService sessionService;

	@Autowired
	AccountConfigurationService accountConfigurationService;

	@Autowired
	UserFunctionsService ufservice;

	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String showHome(Principal principal, Model model) {
		User user = sessionService.getCurrentUser(principal);
		String userId = user.getId();
		model.addAttribute("user", user);

		int newNotificationsSize = visualizationService
				.newNotifications(userId);
		if (newNotificationsSize > 0)
			model.addAttribute("notificationCount", newNotificationsSize);

		List<Notification> notifications = visualizationService
				.showUserNotifications(userId);
		if (notifications.size() > 0)
			model.addAttribute("notifications", notifications);
		else
			model.addAttribute("noNotifications", "You dont have notifications");

		List<Post> feed = visualizationService.showFeed(user.getUsername());
		model.addAttribute("feed", feed);
		return "home";
	}

	@RequestMapping(value = { "profile/{username}" }, method = RequestMethod.GET)
	public String showProfile(Principal principal, Model model,
			@PathVariable String username) {

		User user = sessionService.getCurrentUser(principal);
		String userId = user.getId();
		int newNotificationsSize = visualizationService
				.newNotifications(userId);
		if (newNotificationsSize > 0)
			model.addAttribute("notificationCount", newNotificationsSize);

		List<Notification> notifications = visualizationService
				.showUserNotifications(userId);
		if (notifications.size() > 0)
			model.addAttribute("notifications", notifications);
		else
			model.addAttribute("noNotifications", "You dont have notifications");
		model.addAttribute("user", user);
		if (user.getUsername().equals(username)) {

			List<Post> posts = visualizationService.showUserPost(user
					.getUsername());
			model.addAttribute("posts", posts);

			List<User> followers = visualizationService.showFollowers(user
					.getUsername());
			model.addAttribute("followers", followers);

			List<User> follows = visualizationService.showFollowing(user
					.getUsername());
			model.addAttribute("follows", follows);
			return "profile";
		} else {
			User person = sessionService.getUser(username);
			model.addAttribute("person", person);
			boolean follow = user.getFollows().contains(person.getUsername());

			model.addAttribute("ifollow", follow);

			List<Post> posts = visualizationService.showUserPost(person
					.getUsername());
			model.addAttribute("posts", posts);

			List<User> followers = visualizationService.showFollowers(person
					.getUsername());
			model.addAttribute("followers", followers);

			List<User> follows = visualizationService.showFollowing(person
					.getUsername());
			model.addAttribute("follows", follows);
			return "userprofile";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/profileConfiguration")
	public String showProfileConfiguration(Principal principal, Model model) {
		User user = sessionService.getCurrentUser(principal);
		String userId = user.getId();
		model.addAttribute("user", user);
		int newNotificationsSize = visualizationService
				.newNotifications(userId);
		if (newNotificationsSize > 0)
			model.addAttribute("notificationCount", newNotificationsSize);

		List<Notification> notifications = visualizationService
				.showUserNotifications(userId);
		if (notifications.size() > 0)
			model.addAttribute("notifications", notifications);
		else
			model.addAttribute("noNotifications", "You dont have notifications");
		return "profileConfiguration";
	}

	@RequestMapping(value = { "/home/photo", "/profile/{username}/photo",
			"/profileConfiguration/photo" }, method = RequestMethod.GET)
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

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearch(@RequestParam String value, Model model,Principal principal) {
		User user = sessionService.getCurrentUser(principal);
		model.addAttribute("user",user);
		model.addAttribute("value",value);
		List<Object> result = ufservice.search(value);
		if(result.size()==0) {
			model.addAttribute("type", "empty");
		}
		else if (result.get(0) instanceof User) {
			model.addAttribute("type", "user");
			List<User> userResult = (List<User>) (Object) result;
			model.addAttribute("result", userResult);
		} else {
			model.addAttribute("type", "post");
			List<Post> postResult = (List<Post>) (Object) result;
			model.addAttribute("result", postResult);
		}
		return "search";
	}
}
