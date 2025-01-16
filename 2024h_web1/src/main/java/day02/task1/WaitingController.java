package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/lists")
public class WaitingController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pulson = req.getParameter("pulson");
		int number = Integer.parseInt(req.getParameter("number"));
		
		boolean result = WaitingDao.getInstance().listInsert(pulson, number);
		System.out.println("result");
	}// f end
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num = Integer.parseInt(req.getParameter("num"));
		boolean result = WaitingDao.getInstance().delete(num);
		System.out.println(result);
		
	}// f end
	
	
	
}//class end
