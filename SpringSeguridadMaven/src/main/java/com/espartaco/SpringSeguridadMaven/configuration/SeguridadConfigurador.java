package com.espartaco.SpringSeguridadMaven.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SeguridadConfigurador {

	@Autowired
	private DataSource dataSource;
	
	
	
	
	/**
	 * El JdbcUserDetailsManager se encarga de buscar y gestionar los usuarios almacenados en la base de datos a través del DataSource que le proporcionas.
	 * Por defecto, JdbcUserDetailsManager espera encontrar dos tablas en la base de datos:

			-users: Contiene los detalles de los usuarios.
            -authorities: Contiene los roles y permisos asociados a los usuarios.
		Estructura Esperada de las Tablas: 
			La estructura básica de las tablas que JdbcUserDetailsManager espera es:

			-Tabla users: Debe tener columnas como username, password, y enabled.
			-Tabla authorities: Debe tener columnas como username y authority (donde authority corresponde a los roles).
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
		
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		
		return manager;
		
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	        .authorizeHttpRequests()
	            .requestMatchers("/login","/", "/WEB-INF/view/login.jsp").permitAll()//publico
	            .requestMatchers("/administradores/**").hasRole("ADMIN")
	            .requestMatchers("/usuarios/**").hasRole("USER")
	            .requestMatchers("/managers/**").hasRole("MANAGER")
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
	            .loginPage("/login")
	            .loginProcessingUrl("/autenticacionUsuario")
	            .permitAll()
	        .and()
	        .logout().permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/notacces")
	        .and()
	        .build();
	    
	    
	    
	}
	
	
	
}



/*@Bean
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
}*/