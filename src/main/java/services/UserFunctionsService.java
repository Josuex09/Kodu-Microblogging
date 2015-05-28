package main.java.services;



import java.util.List;

public interface UserFunctionsService {
	public List<Object> search(String value);
	public void publish(String publisherId,String description,String code,String language);
	public void commentPublication(String postId,String userId,String comment);
	public void follow(String currentUserId,String userId);
	public void stopFollowing(String currentUserId,String userId);
}
