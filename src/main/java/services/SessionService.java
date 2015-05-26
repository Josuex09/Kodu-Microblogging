package main.java.services;

import main.java.model.User;

public interface SessionService {
	User signUp(String username,String email,String password);
	void logIn(String username,String password);
	User getCurrentUser(String current_username);
	void logOut(String username);
	boolean validateEmail(String email);
	User getUser(String username);
}


