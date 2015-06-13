package kodu.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kodu.data.FileRepository;
import kodu.model.mongo.Notification;
import kodu.model.mongo.PersistedFile;
import kodu.model.mongo.Post;
import kodu.model.mongo.User;
import kodu.services.AccountConfigurationService;
import kodu.services.SessionService;
import kodu.services.UserFunctionsService;
import kodu.services.VisualizationService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/home")
public class NaviagationBarController {
		@Autowired
		VisualizationService visualizationService;
		
		@Autowired
		SessionService sessionService;
	
		@Autowired
		AccountConfigurationService accountConfigurationService;

	   @RequestMapping(method=RequestMethod.GET)
	   public String feed( Principal principal,Model model) {
		   
		   
		   User user = sessionService.getCurrentUser(principal);
		   String userId = user.getId();

		   
		   model.addAttribute("totalFollowers",user.getFollowers().size());
		   model.addAttribute("totalFollows",user.getFollows().size());
		   model.addAttribute("user",user);
		
		   int newNotificationsSize = visualizationService.newNotifications(userId);
		   if(newNotificationsSize>0) model.addAttribute("notificationCount", newNotificationsSize);
		   
		   List<Notification> notifications =  visualizationService.showUserNotifications(userId);
		   if(notifications.size()>0) model.addAttribute("notifications", notifications);
		   else model.addAttribute("noNotifications","You dont have notifications");
		   
		   List<Post> feed = visualizationService.showFeed(user.getUsername());
		   model.addAttribute("feed", feed);
		   
		    
   	       return "home";
	   }
	   
	    @RequestMapping(value = "/photo", method = RequestMethod.GET)
	    public void showProfilePhoto(HttpServletResponse response,@RequestParam String username) {
	    	try {
	            InputStream photo = visualizationService.showUserProfilePhoto(username);
	            System.out.println(photo == null);
	            if (photo != null) {
	                IOUtils.copy(photo, response.getOutputStream());
	            } else {
	                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	            }
	        } catch(Exception e) { System.out.println("exception");
	        }
	    }   

	
}
