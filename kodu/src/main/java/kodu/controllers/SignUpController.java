package kodu.controllers;


import kodu.model.User;
import kodu.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private SessionService sessionService ;

    @RequestMapping(method = RequestMethod.GET)
    public String show() {
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doSignup(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String confirm) {

        if (!password.equals(confirm)) {
            return "redirect:/signup?passwordMismatch";

        }
        User newUser = sessionService.signUp(username, null, password, confirm);

        if (newUser == null) {
            return "redirect:/signup?usernameAlreadyExists";
        } else {
            return "forward:/greeting";
        }
    }
}
