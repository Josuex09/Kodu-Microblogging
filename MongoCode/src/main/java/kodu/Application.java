package kodu;

import kodu.data.impl.MongoUserRepository;
import kodu.model.User;
import kodu.services.AccountConfigurationService;
import kodu.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner{

	@Autowired
	private MongoUserRepository repository;
	
	@Autowired
	private SessionService service;
	
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
		
		
		System.out.println(service.getUser(repository.findByUsername("josue").getId()));
		
		
	}

}

