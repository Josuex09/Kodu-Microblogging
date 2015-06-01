package kodu.data;
import java.util.List;

import kodu.model.Post;
import kodu.model.User;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String>{
	//public List<Post> findByPublishedOn(Date from, Date to);
	public List<Post> findByUser(User user);
	//public List<Post> findPosts(List<User> users);
}
