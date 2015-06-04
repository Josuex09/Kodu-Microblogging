package kodu.services.impl;

import java.io.InputStream;
import java.util.ArrayList;

import kodu.data.UserRepository;
import kodu.model.User;
import kodu.services.AccountConfigurationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountConfigurationServiceImpl implements AccountConfigurationService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override 
	public User deleteAccount(String userId){ // delete user.
		User user = userRepository.findById(userId);
		userRepository.delete(userId);
		return user;
	} 
	
	@Override
	public User editAccount(String userId,ArrayList<String> languages,
		String password,String location,InputStream picture){
		User user = userRepository.findById(userId);
		user.setLanguages(languages);
		user.setPassword(password);
		user.setLocatedOn(location);
		user.setProfileImage(picture);
		userRepository.save(user);
		return user;
	}


}