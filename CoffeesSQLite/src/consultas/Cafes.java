package consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class Cafes {

	private Connection con;
	private ResultSet resultSet;
	private PreparedStatement prepStatement;
	private Statement statement;
	
	/**
	 * Constructor de la clase Cafes
	 */
	public Cafes() {
		
		resultSet=null;
		prepStatement=null;
		statement=null;
		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:cafes.db");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	
	public void consultaCafeProveedor(int idProveedor) {
		
		
			 try {
				 String query = "SELECT c.*, s.* FROM COFFEES c " +
			                "JOIN SUPPLIERS s ON c.SUP_ID = s.SUP_ID " +
			                "WHERE s.SUP_ID = ?";
				 
				prepStatement = con.prepareStatement(query);
				prepStatement.setInt(1, idProveedor);
				resultSet= prepStatement.executeQuery();
				
				while(resultSet.next()) {
					
					System.out.printf("%-22s %-10d %-15.2f %-10d %-10d %-10s %-10s %-10s %-3s %-6s%n",
				            resultSet.getString("COF_NAME"),
				            resultSet.getInt("SUP_ID"),  // Reemplaza "ID_COLUMN2" con el nombre real de la segunda columna
				            resultSet.getDouble("PRICE"),  // Reemplaza "ID_COLUMN3" con el nombre real de la tercera columna
				            resultSet.getInt("SALES"),  // Reemplaza "ID_COLUMN4" con el nombre real de la cuarta columna
				            resultSet.getInt("TOTAL"),
				            resultSet.getString("SUP_NAME"),
				            resultSet.getString("STREET"),
				            resultSet.getString("CITY"),
				            resultSet.getString("STATE"),
				            resultSet.getString("ZIP"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	
public String borrarCafe(String cOF_NAME) {
		
		String respuesta="error, no se púdo borrar.";
		
		try {
			prepStatement= con.prepareStatement("DELETE FROM COFFEES WHERE COF_NAME=?");
			
			prepStatement.setString(1, cOF_NAME);
			
			
			int filasAfectadas = prepStatement.executeUpdate();
			
			
			if (filasAfectadas > 0) {
	            respuesta="BORRADO exitoso.";
	        } else {
	            respuesta="No se púdo borrar la fila.";
	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return respuesta;
		
	}
	public String insetraFila(String cOF_NAME,int sUP_ID,double pRICE,int sALES,int tOTAL) {
		
		String respuesta="error, no se púdo insertar.";
		
		try {
			prepStatement= con.prepareStatement("INSERT INTO COFFEES(COF_NAME, SUP_ID, PRICE, SALES, TOTAL) VALUES(?,?,?,?,?)");
			
			prepStatement.setString(1, cOF_NAME);
			prepStatement.setInt(2, sUP_ID);
			prepStatement.setDouble(3, pRICE);
			prepStatement.setInt(4, sALES);
			prepStatement.setInt(5, tOTAL);
			
			int filasAfectadas = prepStatement.executeUpdate();
			
			
			if (filasAfectadas > 0) {
	            respuesta="Inserción exitosa.";
	        } else {
	            respuesta="Error al insertar la fila.";
	        }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return respuesta;
		
	}
	
	public void buscaCafe(String nombreDelCafe) {
		
		try {
			prepStatement=con.prepareStatement("Select * From coffees where COF_NAME=? ");
			
			prepStatement.setString(1, nombreDelCafe);
			
			resultSet=prepStatement.executeQuery();
			
			while(resultSet.next()) {
				
				System.out.printf("%-22s %-10d %-15.2f %-10d %-10d%n",
	                      resultSet.getString(1),
	                      resultSet.getInt(2),
	                      resultSet.getDouble(3),
	                      resultSet.getInt(4),
	                      resultSet.getInt(5));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void muestraDatosTabla() {
		
		try {
			statement=con.createStatement();
			resultSet=statement.executeQuery("Select * From coffees ");
			
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnas =metaData.getColumnCount();
			
			for (int i = 1; i <= columnas; i++) {
                String columnaNombre = metaData.getColumnName(i);
                
                System.out.print("|***" + columnaNombre + "***|");
			}
			System.out.println("\n----------------------------------------------------------------------");
			
			while(resultSet.next()) {
				
				System.out.printf("%-22s %-10d %-15.2f %-10d %-10d%n",
	                      resultSet.getString(1),
	                      resultSet.getInt(2),
	                      resultSet.getDouble(3),
	                      resultSet.getInt(4),
	                      resultSet.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo para cerrar una conexion a BD.
	 * @param c la conexion que se va a cerrar
	 */
	public void cerrarConexion() {
		
		try {
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que libera los recursos de una conexion 
	 * en la clase Cafes.
	 * 
	 */
	public void liberarRecursos() {
		
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(prepStatement!=null) {
				prepStatement.close();
			}
			if(statement!=null) {
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the resultSet
	 */
	public ResultSet getResultSet() {
		return resultSet;
	}

	/**
	 * @param resultSet the resultSet to set
	 */
	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	/**
	 * @return the prepStatement
	 */
	public PreparedStatement getPrepStatement() {
		return prepStatement;
	}

	/**
	 * @param prepStatement the prepStatement to set
	 */
	public void setPrepStatement(PreparedStatement prepStatement) {
		this.prepStatement = prepStatement;
	}

	/**
	 * @return the statement
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * @param statement the statement to set
	 */
	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
