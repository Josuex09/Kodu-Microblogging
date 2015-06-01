package kodu.services.impl;

import kodu.data.UserRepository;
import kodu.model.User;
import kodu.services.SessionService;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	UserRepository userRepository;
	


    // *****************
	
	@Override
	public boolean validateEmail(String email){
		
	    boolean valid = EmailValidator.getInstance().isValid(email);
	    if(valid){
			if(userRepository.findByEmail(email) != null){ // must send email...
				return true;
			}
			return false;
	    }
	    
	    return true;

		
	}
	
	@Override
	public User getUser(String userId){
		return userRepository.findById(userId);
	}

	@Override
	public User signUp(String username, String email, String password,
			String passwordConfirm) {
	       if (password.equals(passwordConfirm)) {
	            User existingUser = userRepository.findByUsername(username);
	            if (existingUser == null) {
	                User user = new User(username,password,email); // encode password 
	                return userRepository.save(user);
	            } else {
	            	System.out.println("User already exists");
	                return null;
	            }
	        }

	        return null;
	}
}