package main.java.data;

import java.util.List;

import main.java.data.support.BaseRepository;
import main.java.model.Notification;
import main.java.model.User;


public interface NotificationRepository extends BaseRepository<Notification, String>{
	public List<Notification> findNotification(User user);
}
