package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Readusingstmt {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			
			//DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","root");
			
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root");
			System.out.println("Connection Established");
			
			Statement stmt = con.createStatement();
			System.out.println("Statement Created");
			
			String query = "select * from student";
			
			ResultSet  rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
			}
			System.out.println("Data Fetched");
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	}	
}
