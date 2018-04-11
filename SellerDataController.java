package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.SellerProfile;
import com.model.SellerProfileBo;

/**
 * Servlet implementation class SellerDataController
 */
@WebServlet("/SellerDataController")
public class SellerDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SellerDataController() {
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
		String username = request.getParameter("username");
		System.out.println(username);
		PrintWriter out = response.getWriter();
		SellerProfile profile = new SellerProfile();
		profile.setUsername(username);
		SellerProfileBo data = new SellerProfileBo();
		int health = data.getHealthPercentage(profile);
		System.out.println("Health is "+health);
		out.println("Your health is "+health+"%");
		RequestDispatcher rd = request.getRequestDispatcher("HomePage.html");
		rd.include(request, response);
	}

}
