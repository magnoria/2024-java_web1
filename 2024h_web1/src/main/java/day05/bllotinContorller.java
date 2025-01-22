package day05;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day5/board")
public class bllotinContorller extends HttpServlet {
	
	
	
	// 여기 연결부분은 서버연결이라기 보다는 신호가 가는지 안가는지 확인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 확인");
		//1. HTTP BODY
		ObjectMapper mapper = new ObjectMapper();
		bllotinDto blloDto = mapper.readValue(req.getReader(), bllotinDto.class);
		boolean result = bllotinDao.getInstance().write(blloDto);
		
		//3. 결과 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}//post end
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 확인");
		//1. x
		
		//2. Dao처리
		ArrayList<bllotinDto> result = bllotinDao.getInstance().findAll();
		
		//3. 결과응답
		ObjectMapper mapper = new ObjectMapper();
		String jsonReult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonReult);
		
		
		
	}// get end
	
	
	//3. 게시판 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("put 확인");
		ObjectMapper mapper = new ObjectMapper();
		bllotinDto bllotinDto = mapper.readValue(req.getReader(), bllotinDto.class );
		
		boolean result = bllotinDao.getInstance().update(bllotinDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}//put end
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete 확인");
	}// delete
	
	
	
	
}//class end
