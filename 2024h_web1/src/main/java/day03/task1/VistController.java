package day03.task1;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit")
public class VistController extends HttpServlet {
	
	//1. 방문록 작성 : 등록은 주로 POST , 주로 body
	@Override
	//HTTP POST BODY : http://localhost:8080/2024h_web1/day03/visit
	//content - type : application /json , body : { "content" : "안녕! 방문록 남기고 갑니다." , "age" : "40"  }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. Body(본문)의 JSON을 DTO로 파싱/변환 하기 위한 인스턴스 생성준비
		ObjectMapper mapper = new ObjectMapper();
		//2. 변환
		VisitDto visitDto = mapper.readValue(req.getReader(), VisitDto.class);
		System.out.println(visitDto);
		//3. DAO 처리
		boolean result = VisitDao.getInstance().write(visitDto);
		System.out.println(result);
	}
	
	//2. 방문록 삭제 : 삭제는 주로 DELETE ,요청데이터는 주로 queryString
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. queryString의 매개변수를 파싱하기 위한 코드
		// HTTP DELETE queryString의 매개변수를 파싱 하기 위한 코드
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println("num:" + num);
		//2. DAO처리
		
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
	}// f end
	
}//class end
