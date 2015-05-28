package main.java.data.impl;

import java.util.Date;
import java.util.List;

import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import main.java.connection.OrientDBConnection;
import main.java.data.AbstractBaseRepository;
import main.java.data.PostRepository;
import main.java.data.UserRepository;
import main.java.model.Notification;
import main.java.model.Post;
import main.java.model.User;

public class OrientPostRepository extends AbstractBaseRepository<Post, String> implements PostRepository  {
	private OrientDBConnection conn = new OrientDBConnection();
	@Override
	
	public List<Post> findAll() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		List<Post> queryResult = db.query(new OSQLSynchQuery<User>("select from Post"));
		conn.closeConnection();		
		return queryResult;
	}

	@Override
	public Post findOne(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		List<Post> queryResult = db.query(new OSQLSynchQuery<Post>("select from Post where @rid='"+k+"'"));
		conn.closeConnection();	
		if(queryResult.size()==1)return queryResult.get(0);
		else return null;
	}

	@Override
	public String save(Post t) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		db.save(t);
		conn.closeConnection();
		return null;
	}

	@Override
	public boolean exists(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		List<Post> a = db.query(new OSQLSynchQuery<Post>("select from Post where @rid='"+k+"'"));
		conn.closeConnection();	
		return a.size()==1;
	}

	@Override
	public long count() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		long recordsCount = db.countClass("Post");
		conn.closeConnection();	
		return recordsCount;
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
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		List<Post> queryResult = db.query(new OSQLSynchQuery<Post>("select posts from User where username='"+user.getUsername()+"'"));
		conn.closeConnection();	
		return queryResult;
	}

	@Override
	public List<Post> findPosts(List<User> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
