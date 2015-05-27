package main.java.services.impl;

import java.util.List;

import main.java.data.UserRepository;
import main.java.model.Code;
import main.java.model.Post;
import main.java.model.User;
import main.java.services.UserFunctionsService;

//@Service
public class UserFunctionsServiceImpl implements UserFunctionsService {
	
	private UserRepository userRepository;
	
	
	@Override
	public List<Object> search(String value){
		
	}
	
	@Override
	public void commentPublication(Long postId,String username,String comment){

	}

	@Override
	public void follow(String currentUser, String username) {
		User current = userRepository.findByUserName(currentUser);
		User user = userRepository.findByUserName(username);
		current.addFollow(user);
	}

	@Override
	public void stopFollowing(String currentUser, String username) {
		User current = userRepository.findByUserName(currentUser);
		User user = userRepository.findByUserName(username);
		current.deleteFollow(user);
		
	}

	@Override
	public void publish(String publisher, String description, String code,
			String language) {
		User publisherUser = userRepository.findByUserName(publisher);
		Code postCode = new Code(code, language);
		Post newPost = new Post(description, postCode);
		publisherUser.addPost(newPost);
	}
	


}
