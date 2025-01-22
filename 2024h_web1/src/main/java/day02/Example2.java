package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//1 단계 : extends HttPserVlet
	//2 단계 : @Webservlet("주소정의")
	//3 단계 : http method(get/post/put/delete) 의 메소드를 재정의 한다.


@WebServlet("/day02/example2")
public class Example2 extends HttpServlet {
	
		//1. doget + 자동완성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println("1] 사용자가 서버로부터 get 메소드로 요청했습니다");
				
		// 쿼리스트링의 매개변수를 가져오기
				
				//http://localhost:8080/2024h_web1/day02/example2?name=유재석
				// .getOrameter("URL경로상의 매개변수명"); // 매개변수명의 값(String타입) 반환 함수 , 없으면 NULL
				//System.out.println("1] URL ? 뒤에 있는 'name' 이라는 매개변수명을 가진 변수의 값 가져오기  ");
				System.out.println(req.getParameter("name"));
				
				//http://localhost:8080/2024h_web1/day02/example2?name=유재석&age=40
				//System.out.println("1] URL ? 뒤에 'age' 이라는 매개변수명을 가진 변수의 값 가져오기 ");
				System.out.println(req.getParameter("age"));
				
	}//f end
	
	// 2. dopost
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				System.out.println(" \n 2]사용자가 서버로부터 post 메소드로 요청 했습니다.");
				String name = req.getParameter("name");
				String age = req.getParameter("age");
				System.out.printf("name: %s , age:%s" ,name,age );
	}// f end
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" \n 3]사용자가 서버로부터 put 메소드로 요청 했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name:%s , age: %s " , name , age);
	}//f end
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" \n 4]사용자가 서버로부터 delete 메소드로 요청 했습니다.");
		String  name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name:%s ,age : %s" , name , age);
		
	}
	
	

}//class end
