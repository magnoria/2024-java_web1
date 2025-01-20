package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WaitingDao {

	private Connection conn;
	
	
	private static WaitingDao instance = new WaitingDao();
	
	private WaitingDao() {
		
		try {
			
			Class.forName("com.musql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0116" , "root" , "1234");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}//f end
	
	static WaitingDao getInstance() {
		return instance;
	}
	
	//1. 방문록 등록 SQL
	public boolean write(WaitingDto waitingDto) {
		try {
			String sql = "insert into waiting(people, ponnumber) value (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPeople());
			ps.setInt(2, waitingDto.getPonnumber());
			int count = ps.executeUpdate();
			if (count == 1) { return true;
				
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
		
		
	}//f end
	
	
	//2. 방문록 전체 조회 Sql
	public ArrayList<WaitingDto> findAll() {
		ArrayList<WaitingDto> list = new ArrayList<WaitingDto>();
		
		try {
			String sql = "select * from waiting";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				WaitingDto waitingDto = new WaitingDto();
				waitingDto.setNum(rs.getInt("num"));
				waitingDto.setPeople(rs.getString("people"));
				waitingDto.setPonnumber(rs.getInt("ponnumber"));
				list.add(waitingDto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}//f end
	
	//3. 방문록 수정 Sql
	public boolean update(WaitingDto waitingDto) {
		
		try {
			String sql = " update waiting"
					+ " set people = ? , ponnumber = ?"
					+ " where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getPeople());
			ps.setInt(2, waitingDto.getPonnumber());
			ps.setInt(3, waitingDto.getNum());
			int count = ps.executeUpdate();
			if (count == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
		
		
		
	}//f end
	
	
	//4. 방문록 삭제 SQL
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
