package com.espartaco.SpringSeguridadMaven.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadConfigurador {

	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
		 UserDetails user1 = User.withDefaultPasswordEncoder()
		            .username("user1")
		            .password("123")
		            .roles("USER")
		            .build();

		        UserDetails user2 = User.withDefaultPasswordEncoder()
		            .username("admin")
		            .password("123")
		            .roles("ADMIN","USER")
		            .build();

		        UserDetails user3 = User.withDefaultPasswordEncoder()
		            .username("manager")
		            .password("123")
		            .roles("MANAGER","USER")
		            .build();
        return new InMemoryUserDetailsManager(user1, user2, user3);
    }
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	        .authorizeHttpRequests()
	            .requestMatchers("/", "/WEB-INF/view/login.jsp").permitAll()//publico
	            	.requestMatchers("/administradores/**").hasRole("ADMIN")
	            	.requestMatchers("/usuarios/**").hasRole("USER")
	            	.requestMatchers("/manager/**").hasRole("MANAGER")
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/login")
	            .loginProcessingUrl("/autenticacionUsuario")
	            .permitAll()
	        .and()
	        .logout().permitAll()
	        .and()
	        .build();
	}
	
	
	
}