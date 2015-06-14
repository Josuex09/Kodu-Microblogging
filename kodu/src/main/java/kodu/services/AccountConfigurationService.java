package kodu.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import kodu.model.mongo.User;

import org.springframework.stereotype.Service;

@Service
public interface AccountConfigurationService {
	
	public User deleteAccount(String userId);
	//public User editAccount(String userId,ArrayList<String> languages,String password,String location);
	public String updateProfilePhoto(String userId,String photoFilename,InputStream photo);
	public User editPassword(String userId,String password,String confirmationPassword);
	public User editInformation(String userId,String localization, List<String> languajes);

}
