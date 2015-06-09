package kodu.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import kodu.data.FileRepository;
import kodu.data.NotificationRepository;
import kodu.data.PostRepository;
import kodu.data.UserRepository;
import kodu.model.Medal;
import kodu.model.Notification;
import kodu.model.PersistedFile;
import kodu.model.Post;
import kodu.model.User;
import kodu.services.VisualizationService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisualizationServiceImpl implements VisualizationService {

	//modifique userId por username
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	
	@Override
	public List<User> showFollowers(String userId){
		User user = userRepository.findById(userId);
		List<String> followers = user.getFollowers();
		List<User> followersList = new ArrayList<User>();
		for(int i=0;i<followers.size();i++) followersList.add(userRepository.findById(followers.get(i)));
		return followersList;
	}
	
	@Override
	public List<User> showFollowing(String userId){
		User user = userRepository.findById(userId);
		List<String> following = user.getFollows();
		List<User> followingList = new ArrayList<User>();
		for(int i=0;i<following.size();i++) followingList.add(userRepository.findById(following.get(i)));
		return followingList;
	}

	@Override
	public List<Medal> showMedals(String userId){
		User user = userRepository.findById(userId);
		return user.getMedals();
	}

	@Override
	public List<Post> showFeed(String userId){
		User user = userRepository.findById(userId);
		List<String> follows = user.getFollows();
		List<Post> feed = new ArrayList<Post>();
		// add follows posts
		for(int i=0;i<follows.size();i++){
			User follow = userRepository.findById(follows.get(i));
			List<Post> followPost = new ArrayList<Post>();
			List<String> followPostIds = follow.getPosts();
			for(int j=0;j<followPostIds.size();j++){
				followPost.add(postRepository.findById(followPostIds.get(j)));
			}
			feed.addAll(followPost);
		}
		
		//add own post
		List <String> postsIds = user.getPosts();
		List<Post>  posts = new ArrayList<Post>();
		for(int i=0;i<postsIds.size();i++) posts.add(postRepository.findById(postsIds.get(i)));
		feed.addAll(posts);
		return feed;
	}
	
	@Override
	public List<Post> showUserPost(String userId){
		User user = userRepository.findById(userId);
		List <String> postsIds = user.getPosts();
		List<Post>  posts = new ArrayList<Post>();
		for(int i=0;i<postsIds.size();i++) posts.add(postRepository.findById(postsIds.get(i)));
		return posts;
	}

	@Override
	public List<Notification> showUserNotifications(String userId) {
		User user = userRepository.findById(userId);
		List<String> notificationsIds = user.getNotifications();
		List<Notification> notifications = new ArrayList<Notification>();
		for(int i=0;i<notificationsIds.size();i++)notifications.add(notificationRepository.findById(notificationsIds.get(i)));
		return notifications;
	}

	@Override
	public InputStream showUserProfilePhoto(String userId) {
		User user = userRepository.findById(userId);
		String filename = user.getProfilePhoto();
		if(StringUtils.isNotBlank(filename)){
			PersistedFile profilePhoto = fileRepository.findOne(filename);
			if(profilePhoto != null){
				return profilePhoto.getInputStream();
			}
		}
		return null;
	}


}

