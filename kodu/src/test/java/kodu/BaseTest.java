/*package kodu;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class BaseTest {
	
	 protected static ConfigurableApplicationContext context;

	    @BeforeClass
	    public static void start() throws Exception {
	        Future<ConfigurableApplicationContext> future = Executors
	                .newSingleThreadExecutor().submit(
	                new Callable<ConfigurableApplicationContext>() {
	                    @Override
	                    public ConfigurableApplicationContext call() throws Exception {
	                        return SpringApplication
	                                .run(Application.class);
	                    }
	                });
	        context = future.get(60, TimeUnit.SECONDS);
	    }

	    @AfterClass
	    public static void stop() {
	        if (context != null) {
	            context.close();
	        }
	    }

}
*/