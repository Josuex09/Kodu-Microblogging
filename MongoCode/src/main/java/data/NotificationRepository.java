package data;



import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Notification;

@Repository
public interface NotificationRepository extends  CrudRepository<Notification, String>{
	@Query ("{ 'username' : ?0 }")
	public List<Notification> findNotification(String username);
}
