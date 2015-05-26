package main.java.services;

import java.util.List;

import main.java.model.Post;
import main.java.model.User;

public interface VisualizationService {
	public List<User> showFollowers(String userId);
	public List<User> showFollowing(String userId);
	public List<User> showMedals(String userId);
	public List<Post> showFeed(String userId);
	public List<Post> showUserPost(String userId);
	
	
}
