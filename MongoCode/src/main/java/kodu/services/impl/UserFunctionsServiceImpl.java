package kodu.services.impl;

import java.util.List;

import kodu.data.UserRepository;
import kodu.model.Code;
import kodu.model.Post;
import kodu.model.User;
import kodu.services.UserFunctionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFunctionsServiceImpl implements UserFunctionsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Object> search(String value) {
		// must know if user is searching for a post or a user, and return a
		// list...
		return null;
	}

	@Override
	public void follow(String currentUserId, String usernameId) {
		User user = userRepository.findById(currentUserId);
		User newUser = userRepository.findById(usernameId);
		if (userRepository.findById(usernameId).getFollowers()
				.contains(userRepository.findByUsername(usernameId))) {
			return;
		}
		userRepository.findById(currentUserId).setFollower(
				userRepository.findById(usernameId));
		userRepository.findById(usernameId).setFollower(
				(userRepository.findById(usernameId)));
		userRepository.save(user);
		userRepository.save(newUser);
	}

	@Override
	public void stopFollowing(String currentUserId, String usernameId) {
		User current = userRepository.findById(currentUserId);
		User user = userRepository.findById(usernameId);
		current.deleteFollow(user);
		user.deleteFollower(current);
		userRepository.save(user);
		userRepository.save(current);
	}

	@Override
	public void publish(String publisherId, String description, String code,
			String language) {
		User publisherUser = userRepository.findById(publisherId);
		Code postCode = new Code(code, language);
		Post newPost = new Post(description, postCode, publisherUser);
		publisherUser.setPost(newPost);
	}

	@Override
	public void commentPublication(String postId, String userId, String comment) {
		// TODO Auto-generated method stub

	}

}
