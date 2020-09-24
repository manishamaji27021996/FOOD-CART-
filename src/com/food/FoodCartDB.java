package com.food;



import java.util.ArrayList;
import java.util.List;
import java.sql.*;



public class FoodCartDB {

	public static List<Food> getFoodList() throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/food?useSSL=false";
		String username="root";
		String password="manisha";
		
		ArrayList<Food> food=new ArrayList<>();
		
		//load the mysql driver
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con=DriverManager.getConnection(url, username, password);
		
		//create a statement
		Statement stmt=con.createStatement();
		
		// execute the statement and loop over result set
		ResultSet rs =stmt.executeQuery("select * from food_cart");    // Resultet stores the data in structure format table
		
		while(rs.next()) {
			
			int id =rs.getInt(1);     //1,2,3 are coulmn in database
			String item= rs.getString(2);
			float price= rs.getFloat(3);
			
			Food f= new Food(id, item,price);    //object created of pojo class
			food.add(f);                           //arraylist food
		}
		
		return food;
		
	}
	
	
}
