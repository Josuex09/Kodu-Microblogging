package main.java.services;

import main.java.model.User;

public interface SessionService {
	User signUp(String username,String email,String password,String passwordConfirm);
	boolean validateEmail(String email);
	User getUser(String userId);
}


