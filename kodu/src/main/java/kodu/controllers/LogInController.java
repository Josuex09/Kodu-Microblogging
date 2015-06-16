package kodu.controllers;

import java.util.List;

import kodu.model.mongo.Post;
import kodu.model.mongo.User;
import kodu.services.SessionService;
import kodu.services.UserFunctionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LogInController {

	@Autowired
	private SessionService sessionService;

	@Autowired
	private UserFunctionsService ufservice;

	@RequestMapping(method = RequestMethod.GET)
	public String show() {

		// sessionService.signUp("luis", "123", "123", "123");
		/*List<Object> result = ufservice.search("elastic");
		if (result.get(0) instanceof User) {
			for (int i = 0; i < result.size(); i++) {
				User u = (User) result.get(i);
				System.out.println(u.getUsername());
			}
		} else {
			for (int i = 0; i < result.size(); i++) {
				Post u = (Post) result.get(i);
				System.out.println(u.getDescription());
			}

		}
*/
		return "login";
		
	}

}
