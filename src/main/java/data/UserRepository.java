package main.java.data;

import main.java.model.User;


public interface UserRepository extends BaseRepository<User,String>{
	public User findByUserName(String username);
	public User findUserByEmail(String username);
	
}
