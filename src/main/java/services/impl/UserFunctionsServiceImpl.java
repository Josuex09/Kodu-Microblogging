package main.java.services.impl;

import java.util.List;

import main.java.model.Post;
import main.java.model.User;
import main.java.services.UserFunctionsService;

//@Service
public class UserFunctionsServiceImpl implements UserFunctionsService {

	@Override
	public List<Post> searchPost(String value){

	}

	@Override
	public List<User> searchUser(String username){

	}

	@Override
	public void publish(String description,String content){

	}
	
	@Override
	public void commentPublication(String postId,String comment){

	}
	

	//Deberian de tener el usuario que es y el usuario que 
	//va a seguir o dejar de seguir
	@Override
	public void follow(String userId){

	}
	
	@Override
	public void stopFollowing(String userId){

	}


}
