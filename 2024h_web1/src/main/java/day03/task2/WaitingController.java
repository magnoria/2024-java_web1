package day03.task2;

import java.io.IOException;

import org.apache.catalina.mapper.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		
		WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
		
		boolean result = WaitingDao.getInstance().write(waitingDto); // 여기가 문제인가?
		System.out.println(result);
	
	}//class end
		
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println("num:" + num);
		
		boolean result = WaitingDao.getInstance().delete(num);
		System.out.println(result);
	}
	
	
}//class end
