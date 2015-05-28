package main.java.services.impl;

import java.util.List;

import main.java.data.UserRepository;
import main.java.data.impl.OrientUserRepository;
import main.java.model.Code;
import main.java.model.Post;
import main.java.model.User;
import main.java.services.UserFunctionsService;


public class UserFunctionsServiceImpl implements UserFunctionsService {
	
	private UserRepository userRepository = new OrientUserRepository();
	
	
	@Override
	public List<Object> search(String value){
		 // must know if user is searching for a post or a user, and return a list...
		return null;
	}
	

	@Override
	public void follow(String currentUserId, String usernameId) {
		User current = userRepository.findById(currentUserId);
		User user = userRepository.findById(usernameId);
		//current.addFollow(user);
	}

	@Override
	public void stopFollowing(String currentUserId, String usernameId) {
		User current = userRepository.findById(currentUserId);
		User user = userRepository.findById(usernameId);
		current.deleteFollow(user);
		
	}

	@Override
	public void publish(String publisherId, String description, String code,
			String language) {
		User publisherUser = userRepository.findById(publisherId);
		Code postCode = new Code(code, language);
		Post newPost = new Post(description, postCode,publisherUser);
		//publisherUser.addPost(newPost);
	}


	@Override
	public void commentPublication(String postId, String userId, String comment) {
		// TODO Auto-generated method stub
		
	}
	


}
