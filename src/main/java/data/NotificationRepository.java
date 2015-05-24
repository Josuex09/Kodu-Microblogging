package data;

import java.util.List;

import model.Notification;
import model.User;


public interface NotificationRepository extends BaseRepository{
	public List<Notification> findNotification(User user);
}
