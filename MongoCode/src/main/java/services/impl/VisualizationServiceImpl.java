package services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import data.PostRepository;
import data.UserRepository;
import model.Medal;
import model.Notification;
import model.Post;
import model.User;
import services.VisualizationService;

@Service
public class VisualizationServiceImpl implements VisualizationService {

	//modifique userId por username
	UserRepository userRepository;
	PostRepository postRepository;
	
	@Override
	public List<User> showFollowers(String userId){
		User user = userRepository.findById(userId);
		return user.getFollowers();
	}
	
	@Override
	public List<User> showFollowing(String userId){
		User user = userRepository.findById(userId);
		return user.getFollows();
	}

	@Override
	public List<Medal> showMedals(String userId){
		User user = userRepository.findById(userId);
		return user.getMedals();
	}

	@Override
	public List<Post> showFeed(String userId){
		User user = userRepository.findById(userId);
		List<User> follows =  user.getFollows();
		List<Post> feed = postRepository.findPosts(follows); 
		return feed;    // need to filter the results by date.
	}
	
	@Override
	public List<Post> showUserPost(String userId){
		User user = userRepository.findById(userId);
		return user.getPosts();
	}

	@Override
	public List<Notification> showUserNotifications(String userId) {
		User user = userRepository.findById(userId);
		return user.getNotifications();
	}


}

