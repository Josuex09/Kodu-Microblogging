package services;

import data.UserRepository;
import model.User;

//@Service
public class SessionServiceImpl implements SessionService {
	
	@Override
    public User signUp(String username, String password, String passwordConfirm) {


    }	

    @Override
    void logIn(String username,String password){

    }

    // *****************
    @Override
    User getCurrentUser(String current_username){
    	/*
    	String username = ((UserDetails) ((UsernamePasswordAuthenticationToken) 
    		principal).getPrincipal()).getUsername();*/
        return UserRepository.findByUsername(username);
    }
	
    @Override
	void logOut(String username){

	}
	
	@Override
	boolean validateEmail(String email){

	}
	
	@Override
	User getUser(String username){
		return UserRepository.findByUsername(username);
	}
}