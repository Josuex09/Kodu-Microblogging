package kodu.configuration;

import kodu.services.impl.SessionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration{
    private WebSecurityConfig applicationSecurity = new WebSecurityConfig();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    public WebSecurityConfig applicationSecurity() {
        return applicationSecurity;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return applicationSecurity.authenticationManagerBean();
    }
   
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    SessionServiceImpl userDetailsService ;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**","/js/**","/Idiomas/**","/imagenes/**","/","/bar", "/signup").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").defaultSuccessUrl("/home")
                .permitAll()
                .and()
            .logout()
                .permitAll().and().csrf().disable();
    }
    
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService);
    	};

	}
}