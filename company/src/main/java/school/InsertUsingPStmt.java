package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsingPStmt {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			
			//DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","root");
			
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root");
			System.out.println("Connection Established");
			
			String query = "insert into student values(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
//			pstmt.setInt(1, 104);
//			pstmt.setString(2, "max");
//			pstmt.setInt(3, 70);
//			pstmt.executeUpdate();
//			
//			pstmt.setInt(1, 105);
//			pstmt.setString(2, "Miller");
//			pstmt.setInt(3, 70);
//			pstmt.executeUpdate();
			
			pstmt.setInt(1, 106);
			pstmt.setString(2, "Monty");
			pstmt.setInt(3, 70);
			pstmt.executeUpdate();
			
			System.out.println("Data Inserted");
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
