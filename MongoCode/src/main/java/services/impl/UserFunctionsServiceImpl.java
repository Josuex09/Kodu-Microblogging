package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.UserRepository;
import model.Code;
import model.Post;
import model.User;
import services.UserFunctionsService;


public class UserFunctionsServiceImpl implements UserFunctionsService {
	
	@Autowired
	private UserRepository userRepository;
	
	
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
