package day03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day03.task1.VisitDao;
import day03.task1.VisitDto;

public class WaitingDao {
	
	private Connection conn;
	
	//1. 싱글톤
	private static WaitingDao instance = new WaitingDao();
	
	private WaitingDao() {
		
		try {
		Class.forName("com.musql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mudb0116" ,"root", "1234");
		}catch (Exception e) {System.out.println(e);
			
		}
		
		
	}
	static WaitingDao getInstance() {return instance;}
	
	public boolean write(WaitingDto waitingdto) {
		try {
			String sql = "insert into waiting(people , ponnumber) value (?,?) ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingdto.getPeople());
			ps.setString(2, waitingdto.getPonnumber());
			int count = ps.executeUpdate();
		
			if (count ==1) { return true;
				
			}
			}catch (SQLException e) {System.out.println(e);
				
			}
			return false;
	}// f end
			
			public boolean delete( int num ) {
				
				
				try {
				String sql = "delete from waiting where num =?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, num);
				int count = ps.executeUpdate();
				if (count == 1) { return true;
					
				}
				}catch (SQLException e) {System.out.println(e);
					
				}
				return false;
			}// f end
			
	
	
	
}//class end
