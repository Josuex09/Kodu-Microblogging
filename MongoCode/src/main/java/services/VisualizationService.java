package services;

import java.util.List;

import model.Medal;
import model.Notification;
import model.Post;
import model.User;

public interface VisualizationService {
	public List<User> showFollowers(String userId);
	public List<User> showFollowing(String userId);
	public List<Medal> showMedals(String userId);
	public List<Post> showFeed(String userId);
	public List<Post> showUserPost(String userId);
	public List<Notification> showUserNotifications(String userId);
	
	
}
