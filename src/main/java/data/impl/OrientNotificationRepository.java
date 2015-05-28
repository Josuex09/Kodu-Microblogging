package main.java.data.impl;

import java.util.List;

import main.java.data.AbstractBaseRepository;
import main.java.data.NotificationRepository;
import main.java.model.Notification;
import main.java.model.User;

public class OrientNotificationRepository extends AbstractBaseRepository<Notification, String> implements NotificationRepository  {

	@Override
	public List<Notification> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notification findOne(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Notification t) {
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
	public List<Notification> findNotification(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
