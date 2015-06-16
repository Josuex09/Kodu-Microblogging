package kodu.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/profile").setViewName("userprofile");
        registry.addViewController("/profileconfiguration").setViewName("profileconfiguration");
        registry.addViewController("/search").setViewName("search");
      
    }

}
