console.log("java");

//[1] 회원가입 fetch 함수, 요청함수
const onSignUp = () => {
	
	//1. form을 한번에 가져오기. application/json ===> multipart/form-data(첨부파일)
		//* form-data로 전송할 경우에는 속성명들을 'name' 속성으로 식별한다.
	const signupform = document.querySelector('#signupform'); //form 전체 가져오기
		console.log(signupform);	
	// *. Fetch 함수 이용한 'multipart/form-data'를 전송하는 방법 
		// (1) 전송 할 폼을 바이트(바이너리/스트림) 데이터로 변환, FormData 클래스, new formData(폼DOM);
		const signupformData = new FormData(signupform);
			//signupformData.append("속성명", 값); // 만일 html 폼에 없는 데이터를 폼데이터에 추가하는 방법
		// (2)  fetch 옵션, content-type 생략하면 자동으로 'multipart/for-data' 적용된다.
		const option = {method : 'POST' ,
			//header : { 'Content-type' : ''} //생략한다.
			body : signupformData // JSON.stringfy() : 폼전송은 json 형식이 아니므로 생략한다.
		}
		
			//(3) fetch 요청과 응답
			fetch('/2024h_web1/member/signup' , option)
				.then(response => response.json())// 응답자료를 'application/json' 타입으로 변환
				.then(data => {
					if(data == true){alert('회원가입 성공'); location.href="login.jsp";} //회원가입 성공시 메시지후 로그인페이지로 이동
					else{alert('회원가입 실패'); }
				})
				.catch(error => {console.log(error);}) // fetch 통신 간 오류 발생시
				
	
	
}// f end

