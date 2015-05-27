package main.java.services.impl;

import main.java.data.UserRepository;
import main.java.model.User;
import main.java.services.SessionService;

//@Service
public class SessionServiceImpl implements SessionService {
	UserRepository userRepository;
	
	
	@Override
    public User signUp(String username, String password, String passwordConfirm) {

		return userRepository.findByUserName(username); // INCOMPLETE....
    }	

    @Override
	public void logIn(String username,String password){
    	
    }

    // *****************
    @Override
	public  User getCurrentUser(String username){
    	/*
    	String username = ((UserDetails) ((UsernamePasswordAuthenticationToken) 
    		principal).getPrincipal()).getUsername();*/
        return userRepository.findByUserName(username);
    }
	
    @Override
	public	void logOut(String username){

	}
	
	@Override
	public boolean validateEmail(String email){
			return true; // INCOMPLETE.
	}
	
	@Override
	public User getUser(String username){
		return userRepository.findByUserName(username);
	}
}