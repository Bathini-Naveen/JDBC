package com.alpha.company;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class EmployeeDao { //A class That Interacts with the database where it handles all the SQL Operations
		static Connection con =null;
		static {
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Driver Loaded");
				
				con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/company","postgres","root");
				System.out.println("Connection Established");
			}
			catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		public static void insertEmployee(Employee e) {
			String q="Insert into employee values(?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setInt(1, e.getId());
				pstmt.setString(2, e.getName());
				pstmt.setInt(3, e.getAge());
				pstmt.setInt(4, e.getSal());
				pstmt.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Data Inserted");
		}

		public void updateEmployee(int id, int newSal) {
			String q = "update employee set sal=? where id=?";
			try {
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setInt(1, newSal);
				pstmt.setInt(2, id);
				pstmt.executeUpdate();

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Employee Updated");

		}

		public void deleteEmployee(int id) {
			String q = "delete from employee where id=?";
			try {
				PreparedStatement pstmt = con.prepareStatement(q);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Employee deleted");
		}

		public void viewEmployee() {
			try {
				Statement stmt = con.createStatement();
				String q = "select * from employee";
				ResultSet rs = stmt.executeQuery(q);
				while (rs.next()) {
					System.out.println("Id : " + rs.getInt(1));
					System.out.println("Name : " + rs.getString(2));
					System.out.println("Age : " + rs.getInt(3));
					System.out.println("Salary : " + rs.getInt(4));
					System.out.println("----------");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Employees fetched");
		}

	}
