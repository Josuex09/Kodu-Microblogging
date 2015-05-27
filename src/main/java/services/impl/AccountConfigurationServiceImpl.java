package main.java.services.impl;

import java.io.InputStream;
import java.util.ArrayList;

import main.java.data.UserRepository;
import main.java.model.User;
import main.java.services.AccountConfigurationService;

//@Service
public class AccountConfigurationServiceImpl implements AccountConfigurationService {

	private UserRepository userRepository;
	
	
	//modifique userId por username

	@Override
	public void deleteAccount(String username){
		User user = userRepository.findByUserName(username);
		//Eliminar Usuario
	}

	
	@Override
	public void editAccount(String username,ArrayList<String> languages,
		String password,String location,InputStream picture){

		User user = userRepository.findByUserName(username);
		user.setLanguages(languages);
		user.setLocatedOn(location);
		user.setProfileImage(picture);
	}


}