package Services;

public interface UserFunctionsService {
	public List<Post> searchPost(String value);
	public List<User> searchUser(String value);
	public void publish(String description,String content);
	public void commentPublication(String postId,String comment);
	public void follow(String userId);
	public void stopFollowing(String userId);
}
