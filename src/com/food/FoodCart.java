package com.food;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FoodCart")
public class FoodCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get the data from the database (model)
		
		try {
			List<Food> foodItems =FoodCartDB.getFoodList();    // <Food> Food.java class is called
			request.setAttribute("foodItems", foodItems);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // getting from FoodCartDB 
		
		
		// redirect the data to pages (view)
		          // forward the request to another resource(jsp file) with forward tag 
		RequestDispatcher dispatcher= request.getRequestDispatcher("show-food.jsp");
		dispatcher.forward(request,response);
		
	}

}
