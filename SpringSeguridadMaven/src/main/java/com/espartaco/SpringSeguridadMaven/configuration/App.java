package com.espartaco.SpringSeguridadMaven.configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.espartaco.SpringSeguridadMaven")//escanea los paquetes en busca de componentes beans
@PropertySource("classpath:pensistencia-mysql.properties")//lee el archivo de propiedades
public class App {
	
	/**
	 * Inyeccion del archivo de propiedades
	 */
	@Autowired
	private Environment environment;
	
	
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource seguridadDataSource() {
		
		//pool de conexiones
		
			ComboPooledDataSource seguridadDataSource = new ComboPooledDataSource();
		
		//establecer el driver de JDBC, extrayendo en nombre de la propiedad del inyectado
		
			try {
				seguridadDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//hacer log de propiedades de conexion
		
			logger.info("URL de la BBDD:"+ environment.getProperty("jdbc.url"));
			
			logger.info("Usuario conectado a la base de datos: "+ environment.getProperty("jdbc.user"));
		
		//establece propiedades de conexionde BBDD
		
			seguridadDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
			
			seguridadDataSource.setUser(environment.getProperty("jdbc.user"));
	
			seguridadDataSource.setPassword(environment.getProperty("jdbc.password"));

		
		//establece las propiedades de pool de conexiones
			
			seguridadDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
			
			seguridadDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));

			seguridadDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));

			seguridadDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

		
		return seguridadDataSource;
		
	}
	
	/**Se encarga de resolver las vistas de recursos iternos
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		//la ruta de las vistas
		viewResolver.setPrefix("/WEB-INF/view/");
		
		viewResolver.setSuffix(".jsp");
		
		
		return viewResolver;
		
	}
	
	
}
