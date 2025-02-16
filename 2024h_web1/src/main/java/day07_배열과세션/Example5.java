package day07_배열과세션;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day07/example5")
public class Example5 extends HttpServlet {
        
        //private Map<String, String[]> list = new HashMap(); 
		// -- 요청 JSON 객체들을 여러개 저장하기 위해서 : ArrayList<>
		// -- JSON 객체가 아닌 DTO 혹은 Hashmap을 리스트에 저장 : ArrayList<DTO>
				//--> DTO 사용하지 않는 상황 : 일회성 이동객체, DTO의 멤버변수 정의가 명확하지 않을때 등등
		
			private ArrayList<HashMap<String,String>> list = new ArrayList<>();
        
        @Override 
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	System.out.println("/day07/example5 POST OK ");
        	//1. http 요청에 따른 JSON 타입을 DTO 변환한다. [DTO대신 MAP으로 자동 타입변환]
        	ObjectMapper mapper = new ObjectMapper();
        	HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
        	System.out.println(map);
        	//2. DB처리
        	list.add(map);
        	//3. http 응답처리
        	resp.setContentType("application/json");
        	resp.getWriter().print(true);
        	
        		
        	
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                System.out.println("/day07/example5 GET OK ");
           /*   ObjectMapper mapper = new ObjectMapper();
          String jsonResult = mapper.readValue(req.getReader(), Map<String,String>);
             list = req.getParameterMap();
           System.out.println(list); */
                //1. 요청 매개변수가 없다.
                //2. DB처리
                //3. HTTP 응답처리
                ObjectMapper mapper = new ObjectMapper();
                String jsonResult = mapper.writeValueAsString(list); //list Map을 JSON 문자열 변환
                resp.setContentType("application/json");
                resp.getWriter().print(jsonResult);
                
                
              
        }
        
} // c end