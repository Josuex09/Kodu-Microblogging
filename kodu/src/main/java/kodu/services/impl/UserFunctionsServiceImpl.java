package kodu.services.impl;

import java.util.ArrayList;
import java.util.List;

import kodu.data.impl.es.ElasticSearchPostRepository;
import kodu.data.impl.es.ElasticSearchUserRepository;
import kodu.data.impl.mongo.MongoPostRepository;
import kodu.data.impl.mongo.MongoUserRepository;
import kodu.model.elasticsearch.PostES;
import kodu.model.elasticsearch.UserES;
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

	@Autowired
	ElasticSearchUserRepository esUserRepository;

	@Override
	public List<Object> search(String value) {
		if (value.equals("") || value.equals(null))
			return null;

		String[] content = value.split("\\s+");
		boolean isUser = true;
		for (int i = 0; i < content.length; i++) { // determinate if we are
													// looking for a user or a
													// post.
			if (content[i].charAt(0) != '@') {
				isUser = false;
			}
		}
		if (isUser) { // look for users
			List<Object> users = new ArrayList<Object>();
			for (int j = 0; j < content.length; j++) {
				List<UserES> actualUsers = esUserRepository
						.findByUsernameIsLike(content[j].substring(1));
				for (int h = 0; h < actualUsers.size(); h++) {
					users.add(userRepository.findById(actualUsers.get(h)
							.getId()));
				}

			}
			return users;
		} else { // look for posts
			List<Object> posts = new ArrayList<Object>();
			List<String> users = new ArrayList<String>();
			List<String> words = new ArrayList<String>();

			for (int i = 0; i < content.length; i++) { // split users and tags
				if (content[i].charAt(0) == '@')
					users.add(content[i].substring(1));
				else
					words.add(content[i]);
			}

			for (int i = 0; i < words.size(); i++) {
				List<PostES> actualPosts = new ArrayList<PostES>();
				actualPosts = esPostRepository.findByDescriptionIsLike(words
						.get(i));
				for (int j = 0; j < actualPosts.size(); j++) {
					posts.add(postRepository.findById(actualPosts.get(j)
							.getId()));
				}
				return posts;
			}

		}

		return null;
	}

	@Override
	public User follow(String currentUsername, String username) {
		User currentUser = userRepository.findByUsername(currentUsername);
		User userToFollow = userRepository.findByUsername(username);
		// if already is following dont do anything
		currentUser.addFollows(userToFollow.getUsername());
		userToFollow.addFollower(currentUser.getUsername());
		userRepository.save(currentUser);
		userRepository.save(userToFollow);
		return userToFollow;
	}

	@Override
	// working
	public User stopFollowing(String currentUser, String username) {
		User current = userRepository.findByUsername(currentUser);
		User user = userRepository.findByUsername(username);
		current.deleteFollow(user.getUsername());
		user.deleteFollower(current.getUsername());
		userRepository.save(user);
		userRepository.save(current);
		return user;
	}

	@Override
	public Post publish(String publisherId, String description, String code,
			String language) {
		User publisherUser = userRepository.findById(publisherId);
		Code postCode = new Code(code, language);
		Post newPost = new Post(description, postCode,
				publisherUser.getUsername());
		postRepository.save(newPost);
		esPostRepository.save(new PostES(newPost.getId(), newPost
				.getDescription(), newPost.getUser()));
		publisherUser.setPost(newPost.getId());
		userRepository.save(publisherUser);
		return newPost;
	}

	@Override
	public Comment commentPublication(String postId, String userName,
			String content) {
		Post postCommented = postRepository.findById(postId);
		Comment comment = new Comment(userName, content);
		postCommented.addComment(comment);
		postRepository.save(postCommented);
		return comment;

	}

	@Override
	public Post share(String userName, String postId, String newDescription) {
		Post post = postRepository.findById(postId);
		User sharer = userRepository.findByUsername(userName);
		Post newPost = new Post(newDescription, post.getCode(),
				sharer.getUsername());
		newPost.setCreatedBy(post.getCreatedBy());
		postRepository.save(newPost);
		esPostRepository.save(new PostES(newPost.getId(), newPost
				.getDescription(), newPost.getUser()));
		post.addShared(sharer.getUsername());
		postRepository.save(post);
		sharer.setPost(newPost.getId());
		userRepository.save(sharer);
		return newPost;
	}

}
