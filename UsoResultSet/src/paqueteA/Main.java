package paqueteA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {


	public static void main(String[] args) {
		
		Connection conexion=null;
		Date anio;
		Date anioLimit=Date.valueOf("1981-09-01");
		var a=0;
		Double salario;
		String job;
		int dept;
		
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://192.168.1.36:3306/EmpDept", "root", "Apr0bad0");
			conexion.setAutoCommit(false); // Desactivar la confirmacion automática
			System.out.println("Conectado");
			PreparedStatement statement =conexion.prepareStatement("Select * FROM emp;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
			ResultSet rs=statement.executeQuery();
			
			while(rs.next()) {
				anio= rs.getDate("hiredate");
				salario=rs.getDouble("sal");
				job=rs.getString("job");
				dept=rs.getInt("deptno");
				
				System.out.print(rs.getDate("hiredate")+" "+ rs.getString("ename")+" "+rs.getDouble("sal")+" "+ rs.getString("job"));
				
				
				if(job.equalsIgnoreCase("MANAGER")) 
				{
					
					rs.updateDouble("sal", salario=salario*1.1);//aumento del 10%
					rs.updateRow();
					a++;
					System.out.println(" Actualizado a: "+salario);
				}
				
				if(anio.compareTo(anioLimit)<0 && !(job.equalsIgnoreCase("MANAGER") || job.equalsIgnoreCase("SALESMAN") ))//la fecha de la fila es menor a la fecha limite y no sea MANAGER O SALESMAN
				{
					
					rs.updateDouble("sal", salario=salario*1.15);//aumento del 15%
					rs.updateRow();
					a++;
					System.out.println(" Actualizado a: "+salario);
				}
				if(job.equalsIgnoreCase("ANALYST")&&dept==20)//analistas del departamento 20
				{
					rs.updateDouble("sal", salario=salario*1.05);//aumento del 5%
					rs.updateRow();
					a++;
					System.out.println(" Actualizado a: "+salario);
				}
				if(job.equalsIgnoreCase("SALESMAN")) 
				{
					rs.updateDouble("sal", salario=salario*1.08);//aumento del 8%
					rs.updateRow();
					a++;
					System.out.println(" Actualizado a: "+salario);
				}
				
			}
			System.out.println("Total registros actualizados: "+a);
			
		} catch (SQLException e) {
			
			 try {
	                // Deshacer la transacción en caso de error
	                if (conexion != null) {
	                   
	                	conexion.rollback();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
			
			e.printStackTrace();
		}finally {
			
			if(conexion!=null) {
				
				try {
					conexion.setAutoCommit(true); // Restaurar el modo de confirmacion automatica
					conexion.close();
					System.out.println("Desconectado");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}

	}

}
