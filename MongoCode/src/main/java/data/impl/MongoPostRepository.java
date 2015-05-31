package data.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.AbstractBaseRepository;
import data.PostRepository;
import model.Post;

public class MongoPostRepository extends AbstractBaseRepository<Post, String> implements PostRepository  {

	
	@Autowired
	PostRepository post;
	
	
	@Override
	public <S extends Post> S save(S entity) {
		return post.save(entity);
	}

	@Override
	public <S extends Post> List<S> save(Iterable<S> entities) {
		return (List<S>) post.save(entities);
	}

	@Override
	public Post findOne(String id) {
		return post.findOne(id);
	}

	@Override
	public boolean exists(String id) {
		return post.exists(id);
	}

	@Override
	public List<Post> findAll() {
		return (List<Post>) post.findAll();
	}

	@Override
	public List<Post> findAll(Iterable<String> ids) {
		return (List<Post>) post.findAll(ids);
	}

	@Override
	public long count() {
		return post.count();
	}

	@Override
	public void delete(String id) {
		post.delete(id);
		
	}

	@Override
	public void delete(Post entity) {
		post.delete(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Post> entities) {
		post.delete(entities);
		
	}

	@Override
	public void deleteAll() {
		post.deleteAll();
	}

	@Override
	public List<Post> findByPublishedOn(Date from, Date to) {
		return null;
	}

	@Override
	public List<Post> findByUser(Iterable<String> username) {
		
		return (List<Post>) post.findAll(username);
	}

	@Override
	public List<Post> findPosts(Iterable<String> usersname) {
		return (List<Post>) post.findAll(usersname);
	}



	

}
