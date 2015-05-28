package main.java.data;


import java.util.Date;
import java.util.List;

import main.java.data.support.BaseRepository;
import main.java.model.Post;
import main.java.model.User;

public interface PostRepository extends BaseRepository<Post, String>{
	public List<Post> findByPublishedOn(Date from, Date to);
	public List<Post> findByUser(User user);
	public List<Post> findPosts(List<User> users);
}
