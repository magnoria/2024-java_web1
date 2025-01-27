package day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/day08/waiting")
public class WaitingController extends HttpServlet {
	
	private ArrayList<HashMap<String, String>> lists = new ArrayList<HashMap<String,String>>();
	
	
	//정보입력
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(),HashMap.class );
		System.out.println(map);
		
		lists.add(map);
		//map으로 받을시 왜 바로 넣을 수 있는가? ? 반복문 없이
		
		resp.setContentType("application/json");
		resp.getWriter().print(true);
	}
	
	// 정보 저장된것 아웃
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get ok");
		ObjectMapper mapper = new ObjectMapper();
		String jason = mapper.writeValueAsString(lists);
		System.out.println(jason);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jason);
		
		
		
		
	}//f end
	
	
	//수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("pout ok");
		ObjectMapper mapper = new ObjectMapper();
	}
	
	
	//정보삭제
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("delete ok");
//		ObjectMapper mapper = new ObjectMapper();
//		HashMap<String, String> delete = mapper.readValue(req.getReader(), HashMap.class);
//		
		// 클라이언트 요구한 삭제할 대기번호 
		String 삭제할대기번호 =  req.getParameter("대기번호");
		
		//array list에서 hash맵을 꺼내는 방법
		for( int index = 0 ; index <= lists.size()-1; index++ ) {
			HashMap<String, String> map = lists.get(index);
			System.out.println( map );
			// 기존에 있는 대기번호가 삭제할 대기번호와 같으면 
			if( map.get("대기번호").equals(삭제할대기번호 )) {
				lists.remove(index);
				break;
			}
			
			post get 은 쿼리스트링
		}
		// 그것을 꺼내서 key값을 구별하는 방법
		// 비교하는 if 문을 사용하여 같을시 삭제
		
		
	

	
	
	
	
	
}//class end
