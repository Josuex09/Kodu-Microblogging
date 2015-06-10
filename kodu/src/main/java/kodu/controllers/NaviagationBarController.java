package kodu.controllers;

import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kodu.model.Notification;
import kodu.model.User;
import kodu.services.AccountConfigurationService;
import kodu.services.SessionService;
import kodu.services.VisualizationService;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/feed")
public class NaviagationBarController {
		@Autowired
		VisualizationService visualizationService;
		
		@Autowired
		SessionService sessionService;
	
		@Autowired
		AccountConfigurationService accountConfigurationService;

		

	   @RequestMapping(method=RequestMethod.GET)
	   public String loadNavInfo( Principal principal,Model model) {
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
		    
   	       return "feed";
	   }
	    @RequestMapping(value = "/photo", method = RequestMethod.GET)
	    public void showProfilePhoto(HttpServletResponse response,@RequestParam String id) {
	    	try {
	            InputStream photo = visualizationService.showUserProfilePhoto(id);
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
