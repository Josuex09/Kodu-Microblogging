package kodu.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import kodu.data.FileRepository;
import kodu.data.UserRepository;
import kodu.model.mongo.PersistedFile;
import kodu.model.mongo.User;
import kodu.services.AccountConfigurationService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountConfigurationServiceImpl implements AccountConfigurationService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override 
	public User deleteAccount(String userId){ // delete user.
		User user = userRepository.findById(userId);
		userRepository.delete(userId);
		return user;
	} 
	
	/*
	@Override
	public User editAccount(String userId,List<String> languages,
		String password,String location){
		User user = userRepository.findById(userId);
		user.setLanguages(languages);
		user.setPassword(password);
		user.setLocatedOn(location);
		userRepository.save(user);
		return user;
	}
	*/

	@Override
	public String updateProfilePhoto(String userId, String photoFilename,InputStream photo) {
        User user = userRepository.findByUsername(userId);

        String currentPhoto = user.getProfilePhoto();
        if (StringUtils.isNotBlank(currentPhoto)) {
            fileRepository.delete(currentPhoto);
        }

        String newPhotoFilename = user.getId() + "_" + photoFilename.replace(' ', '_');
        fileRepository.create(new PersistedFile(newPhotoFilename, photo));
        user.setProfilePhoto(newPhotoFilename);
        userRepository.save(user);
        return newPhotoFilename;

	}
	
	@Override
	public User editPassword(String userId, String password,
			String confirmationPassword) {
		User user = userRepository.findById(userId);
		if(password.equals(confirmationPassword)){
			user.setPassword(password);
			userRepository.save(user);
		}
		return user;
	}
	
	@Override
	public User editInformation(String userId, String localization,
			List<String> languages) {
		User user = userRepository.findById(userId);
		user.setLanguages(languages);
		user.setLocatedOn(localization);
		userRepository.save(user);
		return user;
	}


}