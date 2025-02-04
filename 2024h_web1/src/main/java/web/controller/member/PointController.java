package web.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.MemberDao;

@WebServlet("/point")
public class PointController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget test");
		
		
		Object result = null;
		Object objec = req.getAttribute("loginMno");
		if (objec != null) {
			int loginMno = (Integer)objec;
			result = MemberDao.getInstance().getPoinLog(loginMno);
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
		
		
		
		// * 동일한 HTTP 메소드 안에서 서로다른 서비스 구분 하는 방법
			//[1] 포인트 로그 내역 전체 조회와 현재 남은 포인트 조회 를 쿼리스트링 이용하여 서비스 구분
				// type : 조회 서비스 방법 식별, 1 : '포인트 로그 내역 전체 조회' , 2: '현재 남은 포인트 조회'
				// 포인트 로그 내역 전체 조회 : http://localhost:8080/point?type=all
				// 포인트 로그 내역 전체 조회 : http://localhost:8080/point?type=current
		//[1] 서비스 타입 정보를 쿼리스트링 으로 가져오기
		//String type = req.getParameter("type");
		//[2] 타입 정보에 따라 구분
		//if (type.equals("all")) {
			// 전체 조회 dao 호출
			
				
		//}else if (type.equals("current")) {
			// 남은 포인트 조회 dao 호출
		//}else {
			
		//}
		
		
	}// f end
	
	
	
	
	
	
}//class end
