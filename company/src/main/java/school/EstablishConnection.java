package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded");
		
		//DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","root");
		
		DriverManager.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root");
		
		System.out.println("Connection Established");
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
