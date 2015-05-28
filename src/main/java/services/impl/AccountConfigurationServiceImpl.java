package main.java.services.impl;

import java.io.InputStream;
import java.util.ArrayList;

import main.java.data.UserRepository;
import main.java.model.User;
import main.java.services.AccountConfigurationService;

//@Service
public class AccountConfigurationServiceImpl implements AccountConfigurationService {

	private UserRepository userRepository;
	


	@Override 
	public void deleteAccount(String userId){ // delete user.
		userRepository.delete(userId);
	}

	
	@Override
	public void editAccount(String userId,ArrayList<String> languages,
		String password,String location,InputStream picture){
		User user = userRepository.findById(userId);
		user.setLanguages(languages);
		user.setPassword(password);
		user.setLocatedOn(location);
		user.setProfileImage(picture);
	}


}