package data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import model.User;


@Repository
public interface UserRepository extends  MongoRepository<User,String>{
	
	@Query ("{ 'username' : ?0 }")
	public User findByUserName(String username);
	
	@Query ("{ 'id' : ?0 }")
	public User findById(String id);
	
	@Query ("{ 'email' : ?0 }")
	public User findUserByEmail(String email);
	
}
