package connpool;

import java.sql.Connection;

public class programDriver {
	
	public static void main(String[] args) {
		
		ConnectionPool conpool = new ConnectionPool();
		
	for(Connection con : ConnectionPool.connlist) {
			
			System.out.println(con);
		}
	System.out.println("---------");
		
		Connection con1 = conpool.getConnection();
		Connection con2 = conpool.getConnection();
		Connection con3 = conpool.getConnection();	
		Connection con4 = conpool.getConnection();
		Connection con5 = conpool.getConnection();
		
		conpool.returnConnectionObj(con2);
		
		for(Connection c : ConnectionPool.connlist) {
			
			System.out.println(c);
		}
		
		
			
		}
	
}
