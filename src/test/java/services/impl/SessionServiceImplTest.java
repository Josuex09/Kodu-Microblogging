package test.java.services.impl;

import main.java.data.impl.OrientUserRepository;
import main.java.services.impl.SessionServiceImpl;

public class SessionServiceImplTest {
	
	public static void main(String[] args) {
		SessionServiceImpl i = new SessionServiceImpl();
		i.signUp("Ysenia","yesenia@hotmail.es","123","123");
		
		OrientUserRepository a = new OrientUserRepository();
		//List<User> b = a.findAll();
		//for(int i=0; i<b.size();i++)System.out.println(b.get(i).getUsername());
		
		//System.out.println(a.exists("josue"));
		
//		System.out.println(a.count());
	}
}
