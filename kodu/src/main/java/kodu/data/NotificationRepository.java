package kodu.data;

import java.util.List;

import kodu.model.mongo.Notification;
import kodu.model.mongo.User;

import org.springframework.data.repository.CrudRepository;


public interface NotificationRepository extends CrudRepository<Notification, String>{
	public List<Notification> findByUser(User user);
	public Notification findById(String id);
}
