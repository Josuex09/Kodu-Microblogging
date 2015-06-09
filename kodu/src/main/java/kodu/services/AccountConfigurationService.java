package kodu.services;

import java.io.InputStream;
import java.util.ArrayList;

import kodu.model.User;

import org.springframework.stereotype.Service;

@Service
public interface AccountConfigurationService {
	
	public User deleteAccount(String userId);
	public User editAccount(String userId,ArrayList<String> languages,String password,String location);
	public String updateProfilePhoto(String userId,String photoFilename,InputStream photo);

}
