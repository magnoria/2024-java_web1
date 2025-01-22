package day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class bllotinDao {
	

	private Connection conn;
	
	private static bllotinDao instance = new bllotinDao();
	//싱글톤에 db 연동
	private bllotinDao() {
		
		try {
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");// 이부분은 서버연결 부분
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/magnoria", "root" , "1234");// 테이블명이랑 database명을 바꿔넣음
			//개념을 잘정리 해야 할듯
			//이부분에서 오타가 자꾸 생김
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}//p end
	static bllotinDao getInstance() {return instance;}

	//1. 게시판 등록
	
	public boolean write(bllotinDto botDto) {
		try {
			String sql = "insert into sublit(btitle, bcontent, bwriter, bpwd) values (? , ? , ? , ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, botDto.getBtitle());
			ps.setString(2, botDto.getBcontent());
			ps.setString(3, botDto.getBwriter());
			ps.setString(4, botDto.getBpwd());
			int count = ps.executeUpdate();
			if (count == 1) { return true;}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;	
	}// f end
	
	//2. 게시판 조회
	
	public ArrayList<bllotinDto> findAll() {
		ArrayList<bllotinDto> list = new ArrayList<bllotinDto>();
		
		try {
			String sql = "select * from sublit";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bllotinDto bllotinDto =new bllotinDto();
				bllotinDto.setBno(rs.getInt("bno"));
				bllotinDto.setBtitle(rs.getString("btitle"));
				bllotinDto.setBcontent(rs.getString("bwriter"));
				bllotinDto.setBdate(rs.getString("bdate"));
				bllotinDto.setBview(rs.getInt("bview"));
				list.add(bllotinDto);
				
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}// f end
	
	public boolean update(bllotinDto bllotinDto) {
		try {
			String sql = "update sublit set btitle = ? , bcontent = ?, where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bllotinDto.getBtitle());
			ps.setString(2, bllotinDto.getBcontent());
			ps.setInt(3, bllotinDto.getBno());
			int count = ps.executeUpdate();
			if (count == 1) {
				return true;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}//f end
	
	//[3] 게시물 개별 조회
	
	public bllotinDto findById(int bno) {
		
		try {
			String sql = "select * from magnoria where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				bllotinDto bllotinDto = new bllotinDto();
				bllotinDto.setBno(rs.getInt("bno"));
				bllotinDto.setBtitle(rs.getString("btitle"));
				bllotinDto.setBwriter(rs.getString("bwriter"));
				bllotinDto.setBdate(rs.getString("bdate"));
				bllotinDto.setBview(rs.getInt("bview"));
				bllotinDto.setBcontent(rs.getString("bcontent"));
				bllotinDto.setBpwd(rs.getString("bpwd"));
				return bllotinDto;
			
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}//f end
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class end
