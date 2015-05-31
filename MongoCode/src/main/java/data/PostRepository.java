package data;


import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import model.Post;
import model.User;

@Repository
public interface PostRepository extends  MongoRepository<Post, String>{
	public List<Post> findByPublishedOn(Date from, Date to);
	public List<Post> findByUser(String username);
	public List<Post> findPosts(List<User> users);
}
