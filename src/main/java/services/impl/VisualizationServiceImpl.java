package main.java.services.impl;

import java.util.List;

import main.java.data.UserRepository;
import main.java.model.Medal;
import main.java.model.Post;
import main.java.model.User;
import main.java.services.VisualizationService;

//@Service
public class VisualizationServiceImpl implements VisualizationService {

	//modifique userId por username
	UserRepository userRepository;

	@Override
	public List<User> showFollowers(String username){
		User user = userRepository.findByUserName(username);
		return user.getFollowers();
	}
	
	@Override
	public List<User> showFollowing(String username){
		User user = userRepository.findByUserName(username);
		return user.getFollows();
	}

	@Override
	public List<Medal> showMedals(String username){
		User user = userRepository.findByUserName(username);
		return user.getMedals();
	}

	@Override
	public List<Post> showFeed(String username){
		/*
			Buscar usuario
			Buscar seguidos
			Retonrnar los posts de los seguidos
		*/
	}
	
	@Override
	public List<Post> showUserPost(String username){
		User user = userRepository.findByUserName(username);
		return user.getPosts();
	}


}

