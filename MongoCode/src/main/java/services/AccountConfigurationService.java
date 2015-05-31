package services;

import java.io.InputStream;
import java.util.ArrayList;

public interface AccountConfigurationService {
	public void deleteAccount(String userId);
	public void editAccount(String userId,ArrayList<String> languages,String password,String location,InputStream picture);
	
}
