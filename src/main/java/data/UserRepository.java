package main.java.data;

import main.java.data.support.BaseRepository;
import main.java.model.User;


public interface UserRepository extends BaseRepository<User,String>{
	public User findByUserName(String username);
	public User findById(String userId);
	public User findUserByEmail(String email);
	
}
