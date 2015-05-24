package data;



public interface UserRepository<User,String> extends BaseRepository{
	public User findByUserName(String username);
	public User findUserByEmail(String username);
	
}
