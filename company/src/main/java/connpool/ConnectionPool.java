package connpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    static List<Connection>  connlist = new ArrayList<Connection>();
    static int poolsize=4;
    
    static {
    	
    	try {
			Class.forName("org.postgresql.Driver");  //Loading the Driver
		} 
    	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    	for(int i = 1; i <= poolsize; i++) {
    		connlist.add(createConnectionObj());
    	}
    }

	private static Connection createConnectionObj() {
		
		Connection con = null;
		
		try {
				con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/company?user=postgres&password=root");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
     public Connection getConnection() {
    	 if(connlist.size() > 0) { //Check if the Connections are available in the pool 
    		 Connection con = connlist.remove(connlist.size()-1);
    		 return con;  // if yes, removes and returns the last element
    	 }
    	 return createConnectionObj();  //if not,it creates and returns the new Connection (Not From The Pool)
	
}
    public void returnConnectionObj(Connection con) {
    	if(connlist.size() < poolsize) {
    		connlist.add(con);
    	}
    	else {
    		try {
				con.close();
			} 
    		catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    }
    
    
}
