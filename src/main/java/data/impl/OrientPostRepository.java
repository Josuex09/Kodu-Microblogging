package main.java.data.impl;

import java.util.Date;
import java.util.List;

import main.java.data.AbstractBaseRepository;
import main.java.data.PostRepository;
import main.java.data.UserRepository;
import main.java.model.Post;
import main.java.model.User;

public class OrientPostRepository extends AbstractBaseRepository<Post, String> implements PostRepository  {

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findOne(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Post t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String k) {
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
	public List<Post> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> findPosts(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
