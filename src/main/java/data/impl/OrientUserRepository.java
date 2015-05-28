package main.java.data.impl;

import java.util.List;

import main.java.connection.OrientDBConnection;
import main.java.data.AbstractBaseRepository;
import main.java.data.UserRepository;
import main.java.model.User;

import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

public class OrientUserRepository extends AbstractBaseRepository<User, String> implements UserRepository {
	private OrientDBConnection conn = new OrientDBConnection();
	
	
	@Override
	public List<User> findAll() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> queryResult = db.query(new OSQLSynchQuery<User>("select from User"));
		for(int i=0;i<queryResult.size();i++) queryResult.get(i).getUsername();
		conn.closeConnection();
		setUserAsVertex();
		return queryResult;

	}
	@Override
	public User findOne(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> queryResult = db.query(new OSQLSynchQuery<User>("select from User where id='"+k+"'"));
		conn.closeConnection();	
		setUserAsVertex();
		if(queryResult.size()==1)return queryResult.get(0);
		else return null;
	}

	@Override
	public String save(User t) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		String id= nextUserId();String username =t.getUsername();String password=t.getPassword();String email= t.getEmail();
		String insert = "insert into user (id,username,password,email) values ('"+id+"','"+username+"','"+password+"','"+email+"')";
		db.command(new OCommandSQL(insert)).execute();
		System.out.println("Creating user with id="+id);
		conn.closeConnection();
		setUserAsVertex();
		return id;
	}


	@Override
	public boolean exists(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> a = db.query(new OSQLSynchQuery<User>("select from User where id='"+k+"'"));
		conn.closeConnection();
		setUserAsVertex();
		return a.size()==1;
	}

	@Override
	public long count() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		long recordsCount = db.countClass("User");
		conn.closeConnection();	
		setUserAsVertex();
		return recordsCount;
	}

	@Override
	public void delete(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		String update = "delete vertex user where id='"+k+"'";
		db.command(new OCommandSQL(update)).execute();
		System.out.println("User with id="+k+" has been deleted");
		conn.closeConnection();		
		
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
		setUserAsVertex();
		if (a.size()==0) return null;
		else return a.get(0);
	}

	@Override
	public User findUserByEmail(String email) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> a = db.query(new OSQLSynchQuery<User>("select from User where email='"+email+"'"));
		conn.closeConnection();
		setUserAsVertex();
		if (a.size()==0) return null;
		else return a.get(0);
	}

	@Override
	public User findById(String userId) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(User.class);
		List<User> a = db.query(new OSQLSynchQuery<User>("select from user where id='"+userId+"'"));
		User result = a.get(0);result.getUsername();
		conn.closeConnection();	
		setUserAsVertex();
		if (a.size()!=0) return result;
		else return null;
	}
	
	public void setUserAsVertex(){
		OObjectDatabaseTx db = conn.openConnection();
		String update = "Alter class user superclass V";
		db.command(new OCommandSQL(update)).execute();
		conn.closeConnection();
	}
	public String nextUserId(){
		OObjectDatabaseTx db = conn.openConnection();
		String maxInList = db.query(new OSQLSynchQuery<User>("select max(id) from User")).toString();
		if(maxInList.equals("[]"))return "0";
		String temp = maxInList.split(":")[2];
		String max = temp.split("}")[0];
		conn.closeConnection();
		if(max.equals("null")) return "0";
		else{
			return (Integer.parseInt(max)+1)+"";
		}
	}

}
