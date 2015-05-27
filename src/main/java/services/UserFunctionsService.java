package main.java.services;



import java.util.List;

import main.java.model.Post;
import main.java.model.User;

public interface UserFunctionsService {
	public List<Post> searchPost(String value);
	public List<User> searchUser(String value);
	public void publish(String publisher,String description,String code,String language);
	public void commentPublication(Long postId,String usernameme,String comment);
	public void follow(String currentUser,String username);
	public void stopFollowing(String currentUser,String username);
}
