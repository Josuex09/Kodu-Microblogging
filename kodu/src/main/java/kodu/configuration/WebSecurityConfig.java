package kodu.configuration;

import kodu.services.impl.SessionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    SessionServiceImpl userDetailsService ;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**","/js/**","/Idiomas/**","/imagenes/**","/","/bar").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/index").failureUrl("/index?usernameAlreadyExists").defaultSuccessUrl("/feed")
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