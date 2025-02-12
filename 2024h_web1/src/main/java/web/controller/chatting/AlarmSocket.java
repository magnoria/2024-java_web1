package web.controller.chatting;

import java.util.List;
import java.util.Vector;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/alrmsoket")
public class AlarmSocket {
	
	private static List<Session> connList = new Vector<Session>(); //[접속한 클라이언트 소켓 정보(session) 등을 리스트에 저장하기위해 리스트 선언]
	
	@OnOpen // 클라이언트가 서버에 성공적으로 (자동) 연동 했을때
	public void onOpen(Session session) {
		System.out.println(session);
		connList.add(session); // 리스트에 연결/연동/접속 된 클라이언트 소켓 session(정보) 를 리스트에 저장한다.
		
		
	}//f end
	
	
	@OnClose // 클라이언트 와 서버가 연결이 닫혔을때 함수 (자동) 실행
	public void onClose(Session session) {
		
		connList.remove(session); //접속어 , 연결이 닫혔을때 리스트에서 세션 정보를 제거한다.
		
	}//f end
	
	@OnMessage // 클라이언트가 보낸 메시지를 서버가 정석적으로 받았을때. (자동)실행
	public void onMessage(Session session , String message) {
		// - 현재 접속된 모든 클라이언트 소켓들에게 받은 메시지를 보낸다. -
		 for( int index = 0 ; index <= connList.size() - 1 ; index++ ) {
             
             Session client = connList.get(index);
            
             try { client.getBasicRemote().sendText(message);
             }catch (Exception e) {System.out.println( e );}
	}
		 
	}

}// c end
