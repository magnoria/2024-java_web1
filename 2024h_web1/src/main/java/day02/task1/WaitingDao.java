package day02.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	
	private Connection conn;
	
	
	
	private static WaitingDao instance = new WaitingDao();
	
	
	private WaitingDao() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magnoria" , "root" , "1234");
		}catch (Exception e) {
			System.out.println(e);
		}	
		
		
	}// end
	
	static WaitingDao getInstance() {
		return instance;

	}
	
	public boolean listInsert(String pulson , int number){
		
		try {
		String sql = "insert into lists(pulson, number) value (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pulson);
		ps.setInt(2, number);
		int count = ps.executeUpdate();
		if (count == 1) { return true;
			
		}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return false;
		
		
	}// f end
	
	
	public boolean delete(int num) {
		
		try {
		String sql = "delete from lists where num =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, num);
		int count = ps.executeUpdate();
		if (count == 1) {return true;
			
		}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}// f end
	
	

}//class end
