package kodu.services;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import kodu.model.Medal;
import kodu.model.Notification;
import kodu.model.Post;
import kodu.model.User;


@Service
public interface VisualizationService {
	public List<User> showFollowers(String userId);
	public List<User> showFollowing(String userId);
	public List<Medal> showMedals(String userId);
	public List<Post> showFeed(String userId);
	public List<Post> showUserPost(String userId);
	public List<Notification> showUserNotifications(String userId);
	public InputStream showUserProfilePhoto(String userId);
    public Integer newNotifications(String userId);
	
}
