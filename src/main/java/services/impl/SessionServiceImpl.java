package main.java.services.impl;

import main.java.data.UserRepository;
import main.java.data.impl.OrientUserRepository;
import main.java.model.User;
import main.java.services.SessionService;

//@Service
public class SessionServiceImpl implements SessionService {
	//UserRepository userRepository;
	UserRepository userRepository = new OrientUserRepository();
	


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