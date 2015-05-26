package services;

import java.io.InputStream;
import java.util.List;

import data.UserRepository;

//@Service
public class AccountConfigurationServiceImpl implements AccountConfigurationService {

	//modifique userId por username


	@Override
	public void deleteAccount(String username){
		User user = UserRepository.findByUserName(username);
		//Eliminar Usuario
	}

	
	@Override
	public void editAccount(String username,List<String> languages,
		String password,String location,InputStream picture){

		User user = UserRepository.findByUserName(username);
		user.setLenguages(languages);
		user.setLocationOn(location);
		user.setProfileImagen(picture);
	}


}