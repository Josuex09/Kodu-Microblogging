package kodu.services.impl;

import java.util.List;

import kodu.data.impl.MongoPostRepository;
import kodu.data.impl.MongoUserRepository;
import kodu.model.mongo.Code;
import kodu.model.mongo.Comment;
import kodu.model.mongo.Post;
import kodu.model.mongo.User;
import kodu.services.UserFunctionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionsServiceImpl implements UserFunctionsService {

	@Autowired
	private MongoUserRepository userRepository;

	@Autowired
	private MongoPostRepository postRepository;
	
	@Override
	public List<Object> search(String value) {
		// must know if user is searching for a post or a user, and return a
		// list...
		return null;
	}

	@Override
	public User follow(String currentUserId, String usernameId) {
		User currentUser= userRepository.findById(currentUserId);
		User userToFollow = userRepository.findById(usernameId);
		// if already is following dont do anything
		currentUser.addFollows(userToFollow.getId());
		userToFollow.addFollower(currentUser.getId());
		userRepository.save(currentUser);
		userRepository.save(userToFollow);
		return userToFollow;
	}

		
	@Override  //working
	public User stopFollowing(String currentUserId, String usernameId) {
		User current = userRepository.findById(currentUserId);
		User user = userRepository.findById(usernameId);
		current.deleteFollow(user.getId());
		user.deleteFollower(current.getId());
		userRepository.save(user);
		userRepository.save(current);
		return  user;
	}

	@Override
	public Post publish(String publisherId, String description, String code,
			String language) {
		Code postCode = new Code(code, language);
		Post newPost = new Post(description, postCode, publisherId);
		User publisherUser = userRepository.findById(publisherId);
		postRepository.save(newPost);
		publisherUser.setPost(newPost.getId());
		userRepository.save(publisherUser);
		return newPost;
	}

	@Override
	public Comment commentPublication(String postId, String userId, String content) {
		Post postCommented = postRepository.findById(postId);
		Comment comment = new Comment(userId, content);
		postCommented.addComment(comment);
		postRepository.save(postCommented);
		return comment;
		
	}

	@Override
	public Post share(String userId, String postId) {
		Post post = postRepository.findById(postId);
		Post newPost = new Post(post.getDescription(), post.getCode(), userId);
		newPost.setCreatedBy(post.getCreatedBy());
		postRepository.save(newPost);
		return newPost;
	}

}
