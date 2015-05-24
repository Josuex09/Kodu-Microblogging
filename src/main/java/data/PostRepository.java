package data;

import java.sql.Date;
import java.util.List;

import model.Post;
import model.User;

public interface PostRepository extends BaseRepository{
	public List<Post> findByPublishedOn(Date from, Date to);
	public List<Post> findByUser(User user);
	public List<Post> findPosts(List<User> users);
}
