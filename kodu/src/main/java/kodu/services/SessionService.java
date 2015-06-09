package kodu.services;

import java.security.Principal;

import kodu.model.User;

import org.springframework.stereotype.Service;

@Service
public interface SessionService {
	User signUp(String username,String email,String password,String passwordConfirm);
	boolean validateEmail(String email);
	User getUser(String userId);
	User getCurrentUser(Principal principal);
}


