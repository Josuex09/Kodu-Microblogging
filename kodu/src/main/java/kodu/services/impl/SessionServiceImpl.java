package kodu.services.impl;

import java.security.Principal;

import kodu.data.impl.es.ElasticSearchUserRepository;
import kodu.data.impl.mongo.MongoUserRepository;
import kodu.model.elasticsearch.UserES;
import kodu.model.mongo.User;
import kodu.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SessionServiceImpl implements SessionService,UserDetailsService {

	@Autowired
	private MongoUserRepository mongoUserRepository;
	@Autowired
	private ElasticSearchUserRepository esUserRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
    // *****************
	
	@Override
	public boolean validateEmail(String email){
/*		
	    boolean valid = EmailValidator.getInstance().isValid(email);
	    if(valid){
			if(userRepository.findByEmail(email) != null){ // must send email...
				return true;
			}
			return false;
	    }
	*/    
	    return true;

		
	}
	
	@Override  //working
	public User getUser(String username){
		return mongoUserRepository.findByUsername(username);
	}

	@Override  //working
	public User signUp(String username, String email, String password,
			String passwordConfirm) {
	       if (password.equals(passwordConfirm)) {
	            User existingUser = mongoUserRepository.findByUsername(username);
	            if (existingUser == null) {
	                User user = new User(username,password,email); // encode password 
	                mongoUserRepository.save(user);
	                esUserRepository.save(new UserES(user.getId(),user.getUsername()));
	                return mongoUserRepository.save(user);
	            } else {
	            	System.out.println("User already exists");
	                return null;
	            }
	        }

	        return null;
	}

	@Override
	public User getCurrentUser(Principal principal) {
        String username = ((UserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUsername();
        return mongoUserRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
        /*Here add user data layer fetching from the MongoDB.
        I have used mongoUserRepository*/
      User user = mongoUserRepository.findByUsername(username);
      if(user == null){
          throw new UsernameNotFoundException(username);
      }else{
          UserDetails details = user;
          return details;
      }
	}
}