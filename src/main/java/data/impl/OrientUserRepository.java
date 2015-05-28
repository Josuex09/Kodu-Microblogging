package main.java.data.impl;

import java.util.List;

import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import main.java.connection.OrientDBConnection;
import main.java.data.AbstractBaseRepository;
import main.java.data.UserRepository;
import main.java.model.User;

public class OrientUserRepository extends AbstractBaseRepository<User, String> implements UserRepository {
	private OrientDBConnection conn = new OrientDBConnection();
	
	
	@Override
	public List<User> findAll() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> queryResult = db.query(new OSQLSynchQuery<User>("select from User"));
		conn.closeConnection();		
		return queryResult;
	}

	@Override
	public User findOne(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> queryResult = db.query(new OSQLSynchQuery<User>("select from User where username='"+k+"'"));
		conn.closeConnection();	
		if(queryResult.size()==1)return queryResult.get(0);
		else return null;
	}

	@Override
	public String save(User t) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		User u = db.newInstance(User.class);
		u.setEmail(t.getEmail());
		u.setUsername(t.getUsername());
		u.setPassword(t.getPassword());
		db.save(u);
		conn.closeConnection();
		return u.getUsername();
	}


	@Override
	public boolean exists(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> a = db.query(new OSQLSynchQuery<User>("select from User where username='"+k+"'"));
		conn.closeConnection();	
		return a.size()==1;
	}

	@Override
	public long count() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		long recordsCount = db.countClass("User");
		conn.closeConnection();	
		return recordsCount;
	}

	@Override
	public void delete(String k) {
		
		
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public User findByUserName(String username) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> a = db.query(new OSQLSynchQuery<User>("select from User where username='"+username+"'"));
		conn.closeConnection();	
		if (a.size()==0) return null;
		else return a.get(0);
	}

	@Override
	public User findUserByEmail(String email) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> a = db.query(new OSQLSynchQuery<User>("select from User where email='"+email+"'"));
		conn.closeConnection();	
		if (a.size()==0) return null;
		else return a.get(0);
	}
	

}
