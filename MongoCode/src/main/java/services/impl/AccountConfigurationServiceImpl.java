package services.impl;

import java.io.InputStream;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.UserRepository;
import model.User;
import services.AccountConfigurationService;

@Service
public class AccountConfigurationServiceImpl implements AccountConfigurationService {

	@Autowired
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