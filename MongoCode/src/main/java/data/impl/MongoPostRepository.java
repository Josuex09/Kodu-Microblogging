package data.impl;

import java.util.Date;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import data.AbstractBaseRepository;
import data.PostRepository;
import model.Post;
import model.User;


public class MongoPostRepository extends AbstractBaseRepository<Post, String> implements PostRepository  {

	@Override
	public <S extends Post> List<S> save(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Post> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Post> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Post> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Post> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Post> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Post entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Post> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> findByPublishedOn(Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPosts(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}	


}
