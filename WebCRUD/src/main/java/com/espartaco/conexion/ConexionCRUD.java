package com.espartaco.conexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConexionCRUD
 */
@WebServlet("/ConexionCRUD")
public class ConexionCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConexionCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url = "jdbc:mysql://192.168.1.36:3306/PruebasHibernate";
        String username = "espartaco";
        String password = "Apr0bad0";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        try {
        	
        	Class.forName(driver);
        	Connection conexion = DriverManager.getConnection(url, username, password);
        	
        	PrintWriter out=response.getWriter();
        	response.setContentType("text/html");//establece el tipo de salida
        	out.print("Nombre de la BBDD: " + url + "<br>");
        	out.print("conectado");
        	
        	conexion.close();
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
