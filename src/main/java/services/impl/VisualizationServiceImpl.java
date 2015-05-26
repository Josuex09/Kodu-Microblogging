package services;

import java.util.List;

import model.Post;
import model.User;

//@Service
public class VisualizationServiceImpl implements VisualizationService {

	//modifique userId por username


	@Override
	public List<User> showFollowers(String username){
		User user = UserRepository.findByUserName(username);
		return user.getFollowers();
	}
	
	@Override
	public List<User> showFollowing(String username){
		User user = UserRepository.findByUserName(username);
		return user.getFollows();
	}

	@Override
	public List<User> showMedals(String username){
		User user = UserRepository.findByUserName(username);
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
		User user = UserRepository.findByUserName(username);
		return getPosts();
	}


}

