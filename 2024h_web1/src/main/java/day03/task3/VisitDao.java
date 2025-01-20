package day03.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitDao {
	
	private Connection conn;
	
	
	//1. 싱글톤
	private static VisitDao instance = new VisitDao();
	

	private VisitDao() {
		
		try {
		//DB연동  코드:
			//코드 작성전에 필수 : 
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0116" , "root" , "1234");
	}catch (Exception e) {System.out.println(e);
	
	}
		
	}
	static VisitDao getInstance() {
		return instance;
	}
	
	//1. 방문록 등록 SQL
	public boolean write(VisitDto visitDto) {
		try {
		String sql = "insert into visit(content , age) value (?,?) ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, visitDto.getContent());
		ps.setInt(2, visitDto.getAge());
		int count = ps.executeUpdate();
		if (count ==1) { return true;
			
		}
		}catch (SQLException e) {System.out.println(e);
			
		}
		return false;
	}// f end
	
	//2. 방문록 전체 조회 SQL
	public ArrayList<VisitDto> findAll(){
		ArrayList<VisitDto> list = new ArrayList<VisitDto>();
		
		
		try {
			String sql = "select * from visit";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				VisitDto visitDto = new VisitDto();
				visitDto.setNum(rs.getInt("num"));
				visitDto.setContent(rs.getString("content"));;
				visitDto.setAge(rs.getInt("age"));
				list.add(visitDto);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
		
		
		
	}// f end
	
	//3. 방문록 수정 SQL
	public boolean update(VisitDto visitDto) {
		try {
			String sql = " update visit"
					+ " set content = ? , age = ?"
					+ " where num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, visitDto.getContent());
			ps.setInt(2, visitDto.getAge());
			ps.setInt(3, visitDto.getNum());
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
		String sql = "delete from visit where num =?";
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
