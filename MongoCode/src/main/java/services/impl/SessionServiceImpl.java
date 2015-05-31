package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.UserRepository;
import model.User;
import services.SessionService;

@Service
public class SessionServiceImpl implements SessionService {
	//UserRepository userRepository;
	@Autowired
	UserRepository userRepository;
    // *****************
	
	@Override
	public boolean validateEmail(String email){
		// validate email syntax
		if(userRepository.findUserByEmail(email)==null){ // must send email...
			return true;
		}
		return false;
		
	}
	
	@Override
	public User getUser(String userId){
		return userRepository.findById(userId);
	}

	@Override
	public User signUp(String username, String email, String password,
			String passwordConfirm) {
	       if (password.equals(passwordConfirm)) {
	            User existingUser = userRepository.findByUserName(username);
	            if (existingUser == null) {
	                User user = new User(username,password,email); // encode password .
	                String id = userRepository.save(user);
	                return userRepository.findById(id);
	            } else {
	            	System.out.println("User already exists");
	                return null;
	            }
	        }

	        return null;
	}
}