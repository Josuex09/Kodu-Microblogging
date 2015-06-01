package kodu.services;

import org.springframework.stereotype.Service;

import kodu.model.User;

@Service
public interface SessionService {
	User signUp(String username,String email,String password,String passwordConfirm);
	boolean validateEmail(String email);
	User getUser(String userId);
}


