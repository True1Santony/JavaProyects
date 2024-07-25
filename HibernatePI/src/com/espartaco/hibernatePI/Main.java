package com.espartaco.hibernatePI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
	    // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://192.168.1.36:3306/PruebasHibernate";
        String username = "espartaco";
        String password = "Apr0bad0";
 
		try {
			
			Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos");
            
            connection.close();
            
		} catch (SQLException e) {
			System.out.println("ERROR!! ");
			e.printStackTrace();
		}
		
		

	}

}
