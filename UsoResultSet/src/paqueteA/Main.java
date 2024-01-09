package paqueteA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h3>Uso de ResultSet</h3>
 * <p>Este programa actualiza <i>row to row</i> el salario de los empleados. Se llena el <i>ResultSet</i> con una query,
 * se modifica con <i>updateRow()</i> </p>
 * <p>Se hace uso de bloques <i>try-with-resources</i> para el cierre automático de <i>Connection, PreparedStatement y ResultSet</i></p>
 * <p>En la carpeta <b>lib</b> se encuentra el Driver.</p>
 * <a href="https://dev.mysql.com/downloads/connector/j/">Enlace al Connector/J 8.2.0</a>
 * 
 * @version 2.0
 * @author espar
 */
public class Main {

	static  final Date anioLimit = Date.valueOf("1981-09-01");
	
	public static void main(String[] args) {

		var a = 0;// a partir de java 10, para contar las tuplas/rows actualizadas.
		
		// bloque try
		try (Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.36:3306/EmpDept", "root","Apr0bad0");
			PreparedStatement statement = conexion.prepareStatement("Select * FROM emp;",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);) {

			conexion.setAutoCommit(false); // Desactivar la confirmacion automática
			System.out.println("Conectado");

			try (ResultSet rs = statement.executeQuery();)
			{

				while (rs.next()) 
				{
					Date anio = rs.getDate("hiredate");
					Double salario = rs.getDouble("sal");
					String job = rs.getString("job");
					int dept = rs.getInt("deptno");

					System.out.print(rs.getDate("hiredate") + " " + rs.getString("ename") + " " + rs.getDouble("sal")
							+ " " + rs.getString("job"));

					if (job.equalsIgnoreCase("MANAGER"))
					{

						rs.updateDouble("sal", salario = salario * 1.1);// aumento del 10%
						rs.updateRow();
						a++;
						System.out.println("   Actualizado a: " + String.format("%.2f", salario));
					}
					
					// la fecha de la fila es menor a la fecha limite y no sea MANAGER O SALESMAN
					if (anio.compareTo(anioLimit) < 0 && !(job.equalsIgnoreCase("MANAGER") || job.equalsIgnoreCase("SALESMAN")))
					{

						rs.updateDouble("sal", salario = salario * 1.15);// aumento del 15%
						rs.updateRow();
						a++;
						System.out.println("   Actualizado a: " + String.format("%.2f", salario));
					}
					if (job.equalsIgnoreCase("ANALYST") && dept == 20)// analistas del departamento 20
					{
						rs.updateDouble("sal", salario = salario * 1.05);// aumento del 5%
						rs.updateRow();
						a++;
						System.out.println("   Actualizado a: " + String.format("%.2f", salario));
					}
					if (job.equalsIgnoreCase("SALESMAN")) 
					{
						rs.updateDouble("sal", salario = salario * 1.08);// aumento del 8%
						rs.updateRow();
						a++;
						System.out.println("   Actualizado a: " + String.format("%.2f", salario));
					}

					System.out.println(" ");// para separar en la impresión las rows que no se han actualizado.
				}
				System.out.println("Total registros actualizados: " + a);
				//confirmo la transaccion.
				conexion.commit();
				//se establece el autocomit de nuevo.
				conexion.setAutoCommit(true);
				conexion.close();
				

			} catch (SQLException e) 
			{
				// Deshacer la transacción en caso de error
				conexion.rollback();
				e.printStackTrace();
			}

		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

	}

}

