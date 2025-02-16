package web.controller.chatting;

import java.util.List;
import java.util.Vector;

import jakarta.servlet.annotation.WebServlet;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

//서블릿 클래스가 아닌 웹소켓 클래스로 사용할 예정
// - @WebServlet HTTP vs - @ServerEndpoint WS
@ServerEndpoint("/chatSocket")
public class ServerSocket {
	
	//[*]  접속된 세션(접속성공한 클라이언트소켓정보) 저장 , list 컬렉션으로 여러개 Session을 저장하기.
	//* 세션 : 네트워크 상의 정보를 저장하는 공간, HTTP 세션 vs WS 세션 vs DB 세션 있음
	// * static : 프로젝트내 하나의 변수를 만들때 사용되는 키워드 , [전역변수] 
	//static을 넣어야 접속명단 list에 둘다 들어감
	private static List<Session> 접속명단 = new Vector<>();
	
	//[1]서버 소켓에 클라이언트 소켓들이 접속 했을때 , onOpen
	@OnOpen // OnOpen : 서버 소켓에 클라이언트 소켓들이 접속 했을때 이벤트를 구현
	public void onOpen(Session sesstion) {
		// Session : [import] import jakarta.websocket.Session;
		
		System.out.println("클라이언트가 서버에 접속 성공");
		System.out.println( sesstion);
		// * onOpen( 클라이언트가 정상적으로 서버와 접속 성공했을때 )
		접속명단.add(sesstion);//list 컬렉션에 접속 성공한 session
		System.out.println(접속명단);
	}//f end
	
	// [2] 클라이언트 소켓이 서버소켓으로 부터 메시지를 보냈을때, onMessage
	@OnMessage
	public void opMessage(Session session , String message) {
		System.out.println("클라이언트 소켓으로부터 메시지 확인");
		System.out.println(message);
		
		// * 서버가 클라이언트 에게 메시지 전송
		//try {
		//session.getBasicRemote().sendText("클라이언트 소켓 안녕(서버에서 클라이언트로)");
		//}catch (Exception e) {
		//	System.out.println(e);
		//}
		
		//(1) 받은 메시지를 모든 접속된 세션(클라이언트소켓)들에게 메시지 보내기
		//1. 받은메시지 = 매개변수의 message
		//2. 접속 명단 : private static List<Session> 접속명단 = new Vector<>();
		//3. 반복문 이용한 접속 명단 순회
		for(int i = 0; i <= 접속명단.size()-1 ; i++) {
			//4. 접속된 명단의 index번째 세션(접속정보) 가져오기
			Session clientSocket = 접속명단.get(i);
			//5. index번째 세션에 메시지를 보내기
			try {
			clientSocket.getBasicRemote().sendText(message);
			}catch (Exception e) {
				System.out.println(e);
			}
		}//for end
		
		
	}//f ends
	
	//[3] 클라이언트 소켓과 연결이 닫혔을때( 클라이언트소켓(객체)의 포함된 JS가 새로고침/리로드 (객체가 지워졌을때) ) 실행되는 함수
	@OnClose
	public void onClose(Session session) {
		// 클라이언트 소켓과 연결이 닫혔을때 명단에서 제외
		접속명단.remove(session); //접속이 닫힌 클라이언트 소켓을 리스트에서 제거
		
	}//f end
	
	
	
}//class end
