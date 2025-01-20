package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example4")
public class Example4 extends HttpServlet {

	@Override // HTTP GET URL : http://localhost:8080/2024h_web1/day03/example4
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("http get방식으로 요청");
		
		boolean result = true;//응답할 값 1. 응답할 자료 준비
		resp.getWriter().print(result); //2. .getWriter().print(보낼자료);
	}// f end
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("http post방식으로 요청");
		String result ="java";
		resp.getWriter().print(result);
		System.out.println("http로 자료를 응답했습니다");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("http post방식으로 요청");
		int result = 30;
		resp.getWriter().print(result);
		System.out.println("http로 자료를 응답했습니다");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("http delete 방식으로 요청");
		DataDto result = new DataDto("유재석", "40");
		resp.getWriter().print(result);
		System.out.println("HTTP로 자료를 응답했습니다.");
	}//f end
	
}//class end
