package kodu;

import java.util.Arrays;
import java.util.List;

import kodu.data.impl.MongoPostRepository;
import kodu.data.impl.MongoUserRepository;
import kodu.model.Post;
import kodu.model.User;
import kodu.services.AccountConfigurationService;
import kodu.services.SessionService;
import kodu.services.UserFunctionsService;
import kodu.services.VisualizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application  implements CommandLineRunner{

	@Autowired
	private MongoUserRepository repository;
	
	@Autowired
	private MongoPostRepository post_repository;
	@Autowired
	private SessionService service;
	
	@Autowired
	private AccountConfigurationService accservice;
	
	
	@Autowired
	private UserFunctionsService ufservice;
	
	@Autowired VisualizationService vservice;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		//repository.save(new Customer("Alice", "Smith"));
		//repository.save(new Customer("Bob", "Smith"));
		repository.save(new User("josue", "123", "josuex09@hotmail.es"));

		// fetch all customers
		System.out.println("User found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('josue'):");
		System.out.println("--------------------------------");
		User usuario = new User("josuea","josu","a");	
		repository.save(usuario);
		System.out.println("date "+ usuario.getCreatedDate());
		
		System.out.println("---------SSESSION SERVICE TEST----------\n");
		
		System.out.println(service.signUp("carlos","carlos@hotmail.com","123", "123"));
		System.out.println(repository.exists(repository.findByUsername("carlos").getId()));
		
		System.out.println("---------ACCOUNT CONFIG SERVICES TEST----\n");
		String idT = repository.findByUsername("josuea").getId();
		/*System.out.println(repository.exists(idT));
		accservice.deleteAccount(idT);
		System.out.println(repository.exists(idT));
		*/
		
		/*System.out.println(repository.findById(idT));
		accservice.editAccount(idT, null, "aa", "Alajuela",null);
		System.out.println(repository.findById(idT));
		*/
		/*
		System.out.println("-------USER FUNCTIONS SERVICE TEST\n");
		repository.save(new User("Daniel","123","danielito@hotmail.es"));
		repository.save(new User("Diego","asd","dieg8@hotmail.com"));
		repository.save(new User("Victor","asd","dieg8@hotmail.com"));
		repository.save(new User("Julian","asd","dieg8@hotmail.com"));
		String id1 = repository.findByUsername("Daniel").getId();
		String id2 = repository.findByUsername("Diego").getId();
		String id3 = repository.findByUsername("Victor").getId();
		String id4 = repository.findByUsername("Julian").getId();
		ufservice.follow(id1,id2);
		ufservice.follow(id1, id3);
		ufservice.follow(id1, id4);
		//System.out.println(repository.findById(id1).getFollows().size());
		System.out.println(vservice.showFollowing(id1));
		
		*/
		
		//System.out.println(repository.findById(id1).getFollows());
		//ufservice.stopFollowing(id1, id2);
		//System.out.println(repository.findById(id1).getFollows());
		//System.out.println(repository.findById(id2).getFollowers());
		
		/*
		repository.save(new User("Daniel","123","danielito@hotmail.es"));
		String id = repository.findByUsername("Daniel").getId();
		ufservice.publish(id, "this is a description","System.out.println('hola soy josue')","java");
		String postId = repository.findByUsername("Daniel").getPosts().get(0);		
		ufservice.commentPublication(postId, id, "soy un comentario");
		Post p = post_repository.findById(postId);
		*/
		
		
		System.out.println("FEED EXAMPLE------------------");
		repository.save(new User("Daniel","123","x`x`zdanielito@hotmail.es"));
		repository.save(new User("Diego","asd","dieg8@hotmail.com"));
		repository.save(new User("Victor","asd","dieg8@hotmail.com"));
		repository.save(new User("Julian","asd","dieg8@hotmail.com"));
		String id1 = repository.findByUsername("Daniel").getId();
		String id2 = repository.findByUsername("Diego").getId();
		String id3 = repository.findByUsername("Victor").getId();
		String id4 = repository.findByUsername("Julian").getId();
		ufservice.follow(id1,id2);
		ufservice.follow(id1, id3);
		ufservice.follow(id1, id4);
		ufservice.publish(id2, "this is a jquery example","{a{.asd","javascript");
		ufservice.publish(id2, "#c sort","System.out.println('hola soy josue')","c++");
		ufservice.publish(id3, "#csharp helado","System.out.println('hola soy josue')","c#");
		ufservice.publish(id1, "#thread #erlang hilo, de verdad","System.out.println('hola soy josue')","erlang");
		ufservice.publish(id4, "sign up screen","System.out.println('hola soy josue')","html");
		ufservice.publish(id4, "#python easy to use","System.out.println('hola soy josue')","python");
		
		List<Post> feed = vservice.showFeed(id1);
		for(int i=0;i<feed.size();i++) System.out.println(feed.get(i));

	}

}

