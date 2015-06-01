package kodu.services.impl;

import java.util.List;

import kodu.data.PostRepository;
import kodu.data.UserRepository;
import kodu.model.Medal;
import kodu.model.Notification;
import kodu.model.Post;
import kodu.model.User;
import kodu.services.VisualizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisualizationServiceImpl implements VisualizationService {

	//modifique userId por username
	@Autowired
	UserRepository userRepository;
	
	@Autowired
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
		
		List<Post> feed = follows.get(0).getPosts();
		for (int i=1; i<follows.size();i++){
			feed.addAll(follows.get(i).getPosts()); 
		}
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

