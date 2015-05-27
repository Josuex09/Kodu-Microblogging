package main.java.services;



import java.util.List;

public interface UserFunctionsService {
	public List<Object> search(String value);
	public void publish(String publisher,String description,String code,String language);
	public void commentPublication(Long postId,String usernameme,String comment);
	public void follow(String currentUser,String username);
	public void stopFollowing(String currentUser,String username);
}
