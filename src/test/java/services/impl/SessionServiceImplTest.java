package test.java.services.impl;
import main.java.model.User;
import main.java.services.impl.SessionServiceImpl;


public class SessionServiceImplTest {
	public static SessionServiceImpl service = new SessionServiceImpl();
	
	public static void signUpTest(String username,String email,String password, String passwordConfirm){
		service.signUp(username, email, password, passwordConfirm);
	}
	public static User getUserTest(String userId){
		return service.getUser(userId);
	}
	
	
	
	public static void main(String[] args) {
		signUpTest("josue", "josue@hotmail.es", "123", "123");
		System.out.println(getUserTest("0").getUsername());
	}
}
