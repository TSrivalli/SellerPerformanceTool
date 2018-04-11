package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SellerProfileDAO
 */
@WebServlet("/SellerProfileDAO")
public class SellerProfileDAO extends HttpServlet {
	public int calculateHealth(SellerProfile profile) {
		String username = profile.getUsername();
		Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int health = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/sellerperformancetool", "root","123456");
            statement  = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM seller_profile WHERE name ='"+username+"'");
            if(resultSet.next()){
                int TotalParameters = 6;
                int FilledParameters = 0;
                for (int i = 1; i <= 6; i ++) {
                		System.out.println(resultSet.getString(i));
                		if (resultSet.getString(i) != null) {
                			System.out.println(resultSet.getString(i));
                			FilledParameters ++;
                		}
                	}
                System.out.println(FilledParameters);
                System.out.println(TotalParameters);
                health = FilledParameters * 100/ TotalParameters;
                System.out.println("Health:"+health);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return health;
	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerProfileDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
