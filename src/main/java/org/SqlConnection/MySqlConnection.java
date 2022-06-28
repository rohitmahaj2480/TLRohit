package org.SqlConnection;
import java.sql.*; 
public class MySqlConnection {

	public static void main(String[]args) {
		getDataFromSql();
	}
	public static void getDataFromSql(){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			//to establish connection
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/sakila","root","123456789");  
			//here sakila is database name, root is username and password  
			//Create 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from actor Where actor_id=1 ");  
			while(rs.next())  
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}  

