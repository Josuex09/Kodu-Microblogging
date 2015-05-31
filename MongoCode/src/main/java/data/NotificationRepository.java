package data;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import model.Notification;

@Repository
public interface NotificationRepository extends  MongoRepository <Notification, String>{
	public List<Notification> findNotification(String username);
}
