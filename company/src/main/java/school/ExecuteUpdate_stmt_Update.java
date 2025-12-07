package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate_stmt_Update {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded");
		
		//DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","root");
		
		Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root");
		System.out.println("Connection Established");
		
		Statement  stmt = con.createStatement();
		System.out.println("statement created");
		
		//String query1 = "insert into student values(104,'Naveen',92)";
		//String query2 = "insert into student values(102,'sai',98)";
		//String query3 = "insert into student values(103,'Jaggu',100)";
		
		//int a = stmt.executeUpdate(query1);
		//System.out.println(a);
		
		//int b = stmt.executeUpdate(query2);
		//System.out.println(b);
		
		//int c = stmt.executeUpdate(query3);
		//System.out.println(c);
		
		String query5 = "Update student set name='arjun' where id=104";
		stmt.execute(query5);
		System.out.println("updating completed");
		
		String quey6 = "delete from student where id=104";
		stmt.execute(quey6);
		System.out.println("deleteing the row");
		
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
