package data;


import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Post;
import model.User;

@Repository
public interface PostRepository extends  CrudRepository<Post, String>{
	@Query ("{ 'username' : ?0 }")
	public List<Post> findByPublishedOn(Date from, Date to);
	
	@Query ("{ 'username' : ?0 }")
	public List<Post> findByUser(Iterable<String> username);
	
	@Query ("{ 'username' : ?0 }")
	public List<Post> findPosts(Iterable<String> username);
}
