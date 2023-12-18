package mariaDB1;

import java.sql.*;//connection, Statment, ResultSet


public class MariaDBSelect {

	public static void main(String[] args) {
		
	     // Configuración de la conexión a la base de datos
        String url = "jdbc:mysql://192.168.1.36:3306/Mia";
		
			//String url = "jdbc:mysql://TNAS.online/MiNas-221:3306/Mia";
        String username = "espartaco";
        String password = "******";
 
		try {
			//1. CEANDO OBJETO CONEXIÓN
			Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos");
            //2. CREANDO OBJETO STATEMENT
            Statement statement=connection.createStatement();
            //3. EJECUTAR OBJETO STATEMENT, RESULTSET
            ResultSet resultSet=statement.executeQuery("select * from Primera;"); 
            //4. LEER RESULTSET
            while(resultSet.next()) {
            	System.out.println(resultSet.getString("ID")+" "+ resultSet.getString("Nombre"));	
            }
            
          //  connection.close();
		} catch (SQLException e) {
			System.out.println("ERROR!! ");
			e.printStackTrace();
		}
		
		
	}

}
