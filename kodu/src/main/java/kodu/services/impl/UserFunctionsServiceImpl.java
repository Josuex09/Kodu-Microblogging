package kodu.services.impl;

import java.util.List;

import kodu.data.impl.es.ElasticSearchPostRepository;
import kodu.data.impl.mongo.MongoPostRepository;
import kodu.data.impl.mongo.MongoUserRepository;
import kodu.model.elasticsearch.PostES;
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
	
	@Autowired
	private ElasticSearchPostRepository esPostRepository;
	
	
	@Override
	public List<Object> search(String value) {
		// must know if user is searching for a post or a user, and return a
		// list...
		return null;
	}

	@Override
	public User follow(String currentUsername, String username) {
		User currentUser= userRepository.findByUsername(currentUsername);
		User userToFollow = userRepository.findByUsername(username);
		// if already is following dont do anything
		currentUser.addFollows(userToFollow.getUsername());
		userToFollow.addFollower(currentUser.getUsername());
		userRepository.save(currentUser);
		userRepository.save(userToFollow);
		return userToFollow;
	}

		
	@Override  //working
	public User stopFollowing(String currentUser, String username) {
		User current = userRepository.findByUsername(currentUser);
		User user = userRepository.findByUsername(username);
		current.deleteFollow(user.getUsername());
		user.deleteFollower(current.getUsername());
		userRepository.save(user);
		userRepository.save(current);
		return  user;
	}

	@Override
	public Post publish(String publisherId, String description, String code,
			String language) {
		User publisherUser = userRepository.findById(publisherId);
		Code postCode = new Code(code, language);
		Post newPost = new Post(description, postCode, publisherUser.getUsername());
		postRepository.save(newPost);
		esPostRepository.save(new PostES(newPost.getId(), newPost.getDescription()));
		publisherUser.setPost(newPost.getId());
		userRepository.save(publisherUser);
		return newPost;
	}

	@Override
	public Comment commentPublication(String postId, String userName, String content) {
		Post postCommented = postRepository.findById(postId);
		Comment comment = new Comment(userName, content);
		postCommented.addComment(comment);
		postRepository.save(postCommented);
		return comment;
		
	}

	@Override
	public Post share(String userName, String postId,String newDescription) {
		Post post = postRepository.findById(postId);
		User sharer = userRepository.findByUsername(userName);
		Post newPost = new Post(newDescription, post.getCode(), sharer.getUsername());
		newPost.setCreatedBy(post.getCreatedBy());
		postRepository.save(newPost);
		esPostRepository.save(new PostES(newPost.getId(),newPost.getDescription()));
		post.addShared(sharer.getUsername());
		postRepository.save(post);
		sharer.setPost(newPost.getId());
		userRepository.save(sharer);
		return newPost;
	}

}
