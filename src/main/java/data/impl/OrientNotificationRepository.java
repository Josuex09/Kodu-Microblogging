package main.java.data.impl;

import java.util.List;

import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import main.java.connection.OrientDBConnection;
import main.java.data.AbstractBaseRepository;
import main.java.data.NotificationRepository;
import main.java.model.Notification;
import main.java.model.User;

public class OrientNotificationRepository extends AbstractBaseRepository<Notification, String> implements NotificationRepository  {
	private OrientDBConnection conn = new OrientDBConnection();
	
	
	@Override
	public List<Notification> findAll() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Notification.class);
		List<Notification> queryResult = db.query(new OSQLSynchQuery<Notification>("select from Notification"));
		conn.closeConnection();		
		return queryResult;
	}

	@Override
	public Notification findOne(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Notification.class);
		List<Notification> queryResult = db.query(new OSQLSynchQuery<Notification>("select from Notification where @rid='"+k+"'"));
		conn.closeConnection();	
		if(queryResult.size()==1)return queryResult.get(0);
		else return null;
	}

	@Override
	public String save(Notification t) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Notification.class);
		db.save(t);
		conn.closeConnection();
		return null;
	}

	@Override
	public boolean exists(String k) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Notification.class);
		List<Notification> a = db.query(new OSQLSynchQuery<Notification>("select from Notification where @rid='"+k+"'"));
		conn.closeConnection();	
		return a.size()==1;
	}

	@Override
	public long count() {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Notification.class);
		long recordsCount = db.countClass("Notification");
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
	public List<Notification> findNotification(User user) {
		OObjectDatabaseTx db = conn.openConnection();
		db.getEntityManager().registerEntityClass(Notification.class);
		List<Notification> queryResult = db.query(new OSQLSynchQuery<Notification>("select notifications from User where username='"+user.getUsername()+"'"));
		conn.closeConnection();	
		return queryResult;
	}

}
