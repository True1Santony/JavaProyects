package mariaDB1;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class MariaDBManipulacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://192.168.1.36:3306/Mia";
        String username = "espartaco";
        String password = "Apr0bad0";
 
		try {
			//1. CEANDO OBJETO CONEXIÓN
			Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos");
            //2. CREANDO OBJETO STATEMENT
            Statement statement=connection.createStatement();
            
            String sql="UPDATE Primera set ID=111111 where Nombre='Paquito';";
            
            statement.executeUpdate(sql);// el metodo para update, delete, insert.

            System.out.println("DATOS INSERTADOS");
          //  connection.close();
		} catch (SQLException e) {
			System.out.println("ERROR!! ");
			e.printStackTrace();
		}
		
	}

}
