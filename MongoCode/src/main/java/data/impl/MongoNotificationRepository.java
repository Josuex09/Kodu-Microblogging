package data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.mongo.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import data.AbstractBaseRepository;
import data.NotificationRepository;
import model.Notification;
import model.User;

public class MongoNotificationRepository implements NotificationRepository{

	@Autowired
	NotificationRepository notification;
	
	@Override
	public <S extends Notification> List<S> save(Iterable<S> entites) {
		return notification.save(entites);
	}

	@Override
	public List<Notification> findAll() {
		return notification.findAll();
	}

	@Override
	public List<Notification> findAll(Sort sort) {
		return findAll();
	}

	@Override
	public <S extends Notification> S insert(S entity) {
		return notification.insert(entity);
	}

	@Override
	public <S extends Notification> List<S> insert(Iterable<S> entities) {
		return insert(entities);
	}

	@Override
	public Page<Notification> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Notification> S save(S entity) {
		return notification.save(entity);
	}

	@Override
	public Notification findOne(String id) {
		return findOne(id);
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Notification> findAll(Iterable<String> ids) {
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
	public void delete(Notification entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Notification> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Notification> findNotification(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
