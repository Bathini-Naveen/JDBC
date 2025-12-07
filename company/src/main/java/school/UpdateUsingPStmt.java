package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUsingPStmt {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			
			//DriverManager.getConnection("jdbc:postgresql://localhost:5432/school","postgres","root");
			
			Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/school?user=postgres&password=root");
			System.out.println("Connection Established");
			
			String query = "Update student set marks=? where marks=?";
			
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 85);
			pstmt.setInt(2, 70);
			int a = pstmt.executeUpdate();
			
			System.out.println("Data Updated" + a );
		
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