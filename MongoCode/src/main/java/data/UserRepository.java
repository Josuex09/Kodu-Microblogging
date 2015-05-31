package data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import model.User;


@Repository
public interface UserRepository extends  MongoRepository<User,String>{
	public User findByUserName(String username);
	public User findById(String userId);
	public User findUserByEmail(String email);
	
}
