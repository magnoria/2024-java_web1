
//[1] 로그인 정보 요청 함수
const getLoginInfo = () => {
	
 
	//1.
	const option = {method : 'GET'} //get 은 생략가능
	//2.
	
	let loginmenu = document.querySelector('.loginmenu'); // (1) 로그인 메뉴를 출력할 구역 가져오기

	let html = ``;//(2) html 변수 선언

	
	fetch('/2024h_web1/member/info' , option)
		.then(r => r.json())
		.then(data =>{ console.log(data);//코드 변경후 서버가 자동 리스타트되면 세션 초기화 된다
		if(data == null){ 
			console.log("비로그인상태");
			//(3) 각 상태에 따라 로그인 메뉴 구성
			html += `
			  			 <li class="nav-item">
			          <a class="nav-link" href="/2024h_web1/member/login.jsp">로그인</a>  </li>
			        
			        	<li class="nav-item">
			          <a class="nav-link" href="/2024h_web1/member/signup.jsp">회원가입</a> </li>
			  		`
		}else{
			console.log('로그인상태')
			//(3) 각 상태에 따라 로그인 메뉴 구성
			html += `			<li class="nav-item">
			          <a class="nav-link" href="#"><img class="header_profile" src="/2024h_web1/upload/${data.mimg}"/> ${data.mid} 님</a> </li>
			      
					  
					  <li class="nav-item"> <a class="nav-link" href="#"> ${ data.mpoint} POINT </a> </li>	
					  
					  
					    <li class="nav-item">
					  		<a class="nav-link" href="/2024h_web1/member/info.jsp">마이페이지</a> </li>
					  
			       		<li class="nav-item">
			         		<a class="nav-link" href="#" onclick="onLogOut()">로그아웃</a> </li>`
		}
		//(4) 구성한 메뉴들을 innerHTML한다.
		loginmenu.innerHTML = html;
		})
		.catch(e => {console.log(e);})
		
	
}//f end
getLoginInfo(); //JS가 열렸을때 최초 1번 실행

//[2] 로그아웃 요청 함수
const onLogOut = () => {
	
	const option= {method : 'DELETE'}
	fetch('/2024h_web1/member/login' , option)
		.then(response => response.json())
		.then(data => {
			if(data == true){
				alert('로그아웃합니다.');
				location.href="/2024h_web1/member/login.jsp";
			}
		})	
		.catch(e => {console.log(e)})
		
		
		
		
		
// [3] 클라이언트 웹소켓의 객체를 생성하고 서버소켓으로 부터 접속 연동 시도
const alarmSocket = new WebSocket('ws://localhost:8080/2024h_web1/alrmsoket'); 		
		

// [4] 
alarmSocket.onmessage = (msgEvent) => {
	
	//alert(msgEvent); // 알람 메시지를 alert 띄우기
	console.log(msgEvent.data); // 알람메시지를 console.log() 띄우기
	
	// 부트스트랩을 이용한 '부트스트랩의 토스트' 사용해서 만들기
	//1. 어디에
	const alarmbox = document.querySelector('alarmbox')
	//2. 무엇을
	let html = `
			<div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-header">
	    <img src="..." class="rounded me-2" alt="...">
	    <strong class="me-auto">${msgEvent.data}</strong>
	    <small>11 mins ago</small>
	    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
	  </div>
	  <div class="toast-body">
	    Hello, world! This is a toast message.
	  </div>
	</div>`
	
	
	//3. 출력
	
}// f end












		
}//f end