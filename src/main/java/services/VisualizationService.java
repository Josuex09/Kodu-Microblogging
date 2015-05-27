package main.java.services;

import java.util.List;

import main.java.model.Medal;
import main.java.model.Notification;
import main.java.model.Post;
import main.java.model.User;

public interface VisualizationService {
	public List<User> showFollowers(String username);
	public List<User> showFollowing(String username);
	public List<Medal> showMedals(String username);
	public List<Post> showFeed(String username);
	public List<Post> showUserPost(String username);
	public List<Notification> showUserNotifications(String username);
	
	
}
