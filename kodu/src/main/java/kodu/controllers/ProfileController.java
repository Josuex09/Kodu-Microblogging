package kodu.controllers;

import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import kodu.model.mongo.Post;
import kodu.model.mongo.User;
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
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	VisualizationService visualizationService;
	
	@Autowired
	SessionService sessionService;

	@Autowired
	AccountConfigurationService accountConfigurationService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String profile( Principal principal,Model model) {	
		User user = sessionService.getCurrentUser(principal);
		String userId = user.getId();
		model.addAttribute("user", user);
		model.addAttribute("totalFollowers", user.getFollowers().size());
		model.addAttribute("totalFollows", user.getFollows().size());
		model.addAttribute("totalPosts",user.getPosts().size());
	    model.addAttribute("lenguages", user.getLanguages());
	    model.addAttribute("location", user.getLocatedOn());
	    model.addAttribute("totalMedals",user.getMedals().size());
	    
	    List<Post> posts = visualizationService.showUserPost(user.getUsername());
		model.addAttribute("posts", posts);
		   
	    List<User> followers = visualizationService.showFollowers(user.getUsername());
		model.addAttribute("followers", followers);
	    
	    List<User> follows = visualizationService.showFollowing(user.getUsername());
		model.addAttribute("follows", follows);
	    
		return "profile";	
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
