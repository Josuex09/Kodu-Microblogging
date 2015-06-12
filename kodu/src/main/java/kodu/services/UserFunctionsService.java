package kodu.services;



import java.util.List;

import kodu.model.mongo.Comment;
import kodu.model.mongo.Post;
import kodu.model.mongo.User;

import org.springframework.stereotype.Service;

@Service
public interface UserFunctionsService {
	public List<Object> search(String value);
	public Post publish(String publisherId,String description,String code,String language);
	public Comment commentPublication(String postId,String userId,String comment);
	public User follow(String currentUserId,String userId);
	public User stopFollowing(String currentUserId,String userId);
	public Post share(String userId,String postId);
}
