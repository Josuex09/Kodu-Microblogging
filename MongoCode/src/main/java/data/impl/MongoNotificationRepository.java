package data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import data.AbstractBaseRepository;
import data.NotificationRepository;
import model.Notification;


public class MongoNotificationRepository extends AbstractBaseRepository<Notification , String> implements NotificationRepository {

	@Autowired
	NotificationRepository notification;

	@Override	
	public <S extends Notification> S save(S entity) {
		return notification.save(entity);
	}

	@Override
	public <S extends Notification> Iterable<S> save(Iterable<S> entities) {
		return notification.save(entities);
	}

	@Override
	public Notification findOne(String id) {
		return notification.findOne(id);
	}

	@Override
	public boolean exists(String id) {
		return notification.exists(id);
	}

	@Override
	public List<Notification> findAll() {
		return (List<Notification>) notification.findAll();
	}

	@Override
	public List<Notification> findAll(Iterable<String> ids) {
		return (List<Notification>) notification.findAll(ids);
	}

	@Override
	public long count() {
		return notification.count();
	}

	@Override
	public void delete(String id) {
		notification.delete(id);
		
	}

	@Override
	public void delete(Notification entity) {
		delete(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Notification> entities) {
		delete(entities);		
	}

	@Override
	public void deleteAll() {
		deleteAll();
	}

	@Override
	public List<Notification> findNotification(String username) {
		
		return (List<Notification>) notification.findAll();
	}
	
}