
//* 함수명 만들때 JS내장 함수와 겹치는 경우
// 1. 등록 함수 , 실행조건 : 등록버튼을 클릭했을때
const visitWrite = () => {
	
	//1. HTML 으로 부터 input dom객체 가져오기
	// -  document.querySelector( 선택자 ) : 선택자 마크업을 객체로 반환함수
	let contentInput = document.querySelector('.contentInput')
	let ageInput = document.querySelector('.ageInput')
	
	//2. 입력받은 값 가져오기
	// - .value : 마크업의 value 속성
	let content = contentInput.value;
	let age = ageInput.value;
	
	//3. 객체화
	// - {속성명 : 값, 속성명 : 값}
	let dataObj = {'content' : content , 'age' : age };
	
	//4. fetch 통신
	let option = {
		method : 'POST',
		header : { 'Content-Type' : 'application/json'}, //HTTP 요청 HEADERS CONTENT - TYPE
		body : JSON.stringify(dataObj)// 본문에 보낼 자료를 문자열타입으로 변환
	}// o end
	fetch(`/2024h_web1/day03/visit2`, option)
		.then(r => r.json())
		.then(data =>{
			//5. 결과에 따른 화면 구현
			if(data == true){alert('등록성공'); visitFindAll();}
			else{alert('등록실패');}
			
		})// then2 end
		.catch(e=> {console.log(e);})
	
	//5. 결과에 따른 화면 구현	
	
}// f end


// 2. 전체 조회 함수 , 실행조건 : 1. JS열릴때 2.등록/수정/삭제 성공했을때

const visitFindAll = () => {
	//1. 어디에, tbody
	let tbody = document.querySelector('tbody')
	
	//2. 무엇을, fetch 으로 받은 자료들을
	let html = '';
		//2-1 fetch 이용한 서블릿에게 자료를 HTTP GET METHOD 요청
		const option = {method : 'GET'}
		//2-2 fetch
		fetch('/2024h_web1/day03/visit2')
			.then( r => r.json() ) //통신 응답 성공시 json타입으로 변환
			.then( data => {
				//방법 1
				//for(int i = 0; i <= data.lenth-1; i++)
				//방법 2
				//data.forEach(obj => {})
				data.forEach( obj => {
					
					html += `<tr>
								<td> ${ obj.num}</td>
								<td> ${ obj.content}</td>
								<td> ${ obj.age}</td>
								<td>
									<button onclick="visitUpdate( ${obj.num})">수정</button>
									<button onclick="visitDelete( ${obj.num})">삭제</button>
								</td>
							</tr>`
					
				})	//for end
				//3. 출력
					//.innerHTML : 지정한 마크업의 html문자열 대입하는 속성
				tbody.innerHTML = html;
			}) // then2 end
			.catch(e => {console.log(e)})

}// f end
visitFindAll(); // 1.JS열릴떄

// 3. 수정함수 , 누구를 수정할껀지 = num[pk]
const visitUpdate = (num) => { // prompt()함수로 수정할 content/age 받기
	//1. 수정할 식별자(num)
	//2. 수정할 내용 content/age
	let newContent = prompt('new Content : '); //prompt() 알림창에서 입력input 지원하는 함수
	let newAge = prompt('new Age:');
	
	//3. 객체화 , {수정할번호, 수정할내용 ,수정할 나이}
	let dataObj = {num : num , content : newContent , age : newAge}
	
	//4. fetch 이용한 서블릿에게 HTTP PUT METHODE 처리 요청, BODY
	const option = {
		method : 'PUT',
		header : { 'Content-Type' : 'application/json'} ,
		body : JSON.stringify(dataObj)
		
	}// o end
	fetch('/2024h_web1/day03/visit2' , option)
		.then(r => r.json())
		.then(data => {
			if(data == true){alert('수정성공'); visitFindAll();}
			else{alert('수정실패');}
		})
		.catch(e => {console.log(e);})
 }


// 4. 삭제함수 , 누구를 삭제할껀지 = num[pk]
const visitDelete = (num) => { 
	//1. 삭제할 식별자(num)
	//2. fetch 이용한 서블릿에게 HTTP delete METHOD 처리 요청 , queryString 으로 보내야한다.
	const option = {method : 'DELETE'}
	fetch( `/2024h_web1/day03/visit2?num=${num}` , option)
		.then(r => r.json()) // 응답결과를 json타입으로 변환
		.then(data => {
			if(data == true){alert('삭제성공'); visitFindAll();}
			else{alert('삭제실패');}
			
		})
		.catch( e => {console.log(e);} )
}






