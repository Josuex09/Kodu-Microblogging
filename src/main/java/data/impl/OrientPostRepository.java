package main.java.data.impl;

import java.util.Date;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import main.java.connection.OrientDBConnection;
import main.java.data.AbstractBaseRepository;
import main.java.data.PostRepository;
import main.java.model.Code;
import main.java.model.Post;
import main.java.model.User;

import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

public class OrientPostRepository extends AbstractBaseRepository<Post, String> implements PostRepository  {
	private OrientDBConnection conn = new OrientDBConnection();
	@Override
	
	public List<Post> findAll() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		List<Post> queryResult = db.query(new OSQLSynchQuery<Post>("select from Post"));
		for(int i=0;i<queryResult.size();i++) queryResult.get(i).getDescription();
		conn.closeConnection();
		return queryResult;
	}

	@Override
	public Post findOne(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		List<Post> queryResult = db.query(new OSQLSynchQuery<Post>("select from Post where id='"+k+"'"));
		conn.closeConnection();	
		if(queryResult.size()==1)return queryResult.get(0);
		else return null;
	}

	@Override
	public String save(Post t) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		db.getEntityManager().registerEntityClass(Code.class);
		db.getEntityManager().registerEntityClass(User.class);
		t.setId(nextPostId());
		db.save(t);
		setUserAsVertex();
		conn.closeConnection();
		return null;
	}

	@Override
	public boolean exists(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Post.class);
		List<Post> a = db.query(new OSQLSynchQuery<Post>("select from Post where id='"+k+"'"));
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
		OObjectDatabaseTx db = conn.openConnection();
		String update = "delete from post where id='"+k+"'";
		db.command(new OCommandSQL(update)).execute();
		System.out.println("post with id="+k+" has been deleted");
		conn.closeConnection();		
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
	public void setUserAsVertex(){
		OObjectDatabaseTx db = conn.openConnection();
		String update = "Alter class user superclass V";
		db.command(new OCommandSQL(update)).execute();
		conn.closeConnection();
	}
	public String nextPostId(){
		OObjectDatabaseTx db = conn.openConnection();
		String maxInList = db.query(new OSQLSynchQuery<Post>("select max(id) from Post")).toString();
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
