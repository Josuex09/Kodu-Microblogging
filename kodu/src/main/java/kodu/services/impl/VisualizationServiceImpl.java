package kodu.services.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kodu.data.FileRepository;
import kodu.data.NotificationRepository;
import kodu.data.PostRepository;
import kodu.data.UserRepository;
import kodu.model.mongo.Medal;
import kodu.model.mongo.Notification;
import kodu.model.mongo.PersistedFile;
import kodu.model.mongo.Post;
import kodu.model.mongo.User;
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
	public List<User> showFollowers(String username){
		User user = userRepository.findByUsername(username);
		List<String> followers = user.getFollowers();
		List<User> followersList = new ArrayList<User>();
		for(int i=0;i<followers.size();i++) followersList.add(userRepository.findByUsername(followers.get(i)));
		return followersList;
	}
	
	@Override
	public List<User> showFollowing(String username){
		User user = userRepository.findByUsername(username);
		List<String> following = user.getFollows();
		List<User> followingList = new ArrayList<User>();
		for(int i=0;i<following.size();i++) followingList.add(userRepository.findByUsername(following.get(i)));
		return followingList;
	}

	@Override
	public List<Medal> showMedals(String userId){
		User user = userRepository.findById(userId);
		return user.getMedals();
	}

	@Override
	public List<Post> showFeed(String username){
		User user = userRepository.findByUsername(username);
		List<String> follows = user.getFollows();
		List<Post> feed = new ArrayList<Post>();
		// add follows posts
		for(int i=0;i<follows.size();i++){
			User follow = userRepository.findByUsername(follows.get(i));
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
	public List<Post> showUserPost(String username){
		User user = userRepository.findByUsername(username);
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
			PersistedFile profilePhoto = fileRepository.findById(filename);
			if(profilePhoto != null){
				System.out.println(profilePhoto.getFilename());
				return profilePhoto.getInputStream();
			}
		}
		return null;
	}

	@Override
	public Integer newNotifications(String userId) {
		User user = userRepository.findById(userId);
		List<String> notificationsIds = user.getNotifications();
		List<Notification> notifications = new ArrayList<Notification>();
		for(int i=0;i<notificationsIds.size();i++)notifications.add(notificationRepository.findById(notificationsIds.get(i)));
		int count =0;
		for(int i=0;i<notifications.size();i++){
			if(!notifications.get(i).isSeen()) {
				count++;
			}
		}
		return count;
	}

	@Override
	public List<Post> showPostsByDateAndRegion(String region, Date from, Date to) {
		return null;
	}


}

