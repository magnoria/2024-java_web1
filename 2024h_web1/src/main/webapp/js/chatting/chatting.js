console.log("확인");

// [1] websocket 클래스 이용하여 클라이언트 소켓 구현 , WebSocket 과 fetch는 비동기 통신
// new WebSocket('서버소켓주소');					, 비동기 통신은 요청하고 응답이 올때까지 JS 코드 흐름을 대기하지 않는 구조
let clientSocket = new WebSocket('ws://localhost:8080/2024h_web1/chatSocket');


//[2] 접속(상태유지)된 서버소켓에게 메시지 전송 .send("메시지") 
//clientSocket.send('js소켓 확인'); // 오류 발생 즉] 접속 요청후 응답 성공 전에 실행했으므로 

// [전송] 버튼을 클릭했을때 실행 할 함수 
const onMsgSend = ( ) => {
	
	//(1) 입력받은 값 가져오기
	const msginput = document.querySelector('.msginput')
	const msg = msginput.value;
	
	//(2) 입력받은 값 보내기
	clientSocket.send(msg);// 클라이언트에서 서버에 메시지를 보낼때
	
}//f end

//[3] 서버 소켓이 클라이언트 소켓으로 부터 메시지를 보냈을때(메시지를 받았을때)
clientSocket.onmessage = (msgEvent) => {
	console.log('서버소켓으로부터 메시지 확인');
	//console.log(clientSoket);
	console.log(msgEvent.data);
	
	//(1) 받은 메시지를 html에 출력하기
	//1. 어디에
	const msgbox = document.querySelector('.msgbox');
	//2. 무엇을
	let html = `<div> ${msgEvent.data}</div>`;
	//3. 출력 , = 대입 (기존값사라짐) , += (기존값연결) 사용한이유 : 앞전 메시지와 연결하기 위해
	msgbox.innerHTML += html;
}

