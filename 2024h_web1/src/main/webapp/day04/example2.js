

// [1] 람다식 함수 정의
// const 상수명 = () => {}
const func1 = () => {
	console.log('func1 execute');
}// f end

//[2] 람다식 함수 정의 안에서 fetch함수 활용
const func2 = () => {
	
	// **fetch : HTTP 비동기 통신 제공하는 함수
	// day02의 example1 서블릿 클래스의 doget 메소드 매핑
	fetch(`http://localhost:8080/2024h_web1/day02/example1`);
	
}//f end

const func3 = () =>{
	fetch(`/2024h_web1/day02/example1`, {method:'POST'})
}//f end

const func4 = () =>{
	fetch(`/2024h_web1/day02/example1`, {method:'PUT'})
	
}//f end

const func5 = () => {
	fetch(`/2024h_web1/day02/example1`, {method:'DELETE'})
}// f end

const func6 = () => {
	let name = '유재석'; let age = 20;
	fetch(`/2024h_web1/day02/example2?name=${ name }&age=${age}`)
	
}

const func7 = () => {
	let name = '신동엽'; let age = 30;
	const option = {method : 'POST'}
	fetch(`/2024h_web1/day02/example2?name=${name}&age=${age}`, option)
	
	
}
const func8 = () => {
	let name = "서장훈"; let age = 10;
	const option = {method : 'PUT'}
	fetch(`/2024h_web1/day02/example2?name=${name}&age=${age}`, option)
	
	
}

const func9 = () => {
	let name = "김희철"; let age = 50;
	const option = {method : 'DELETE'}
	fetch(`/2024h_web1/day02/example2?name=${name}&age=${age}`, option)
	
	
}//f end

const func10 = () => {
	let object = {data1 : '유재석' , data2 : 50}
	const option = {
		method : 'POST' ,
		header : {'Content-Type' : 'application/json'} ,
		body : JSON.stringify(object) // HTTP 통신은 문자열 자료만 전송이 가능하기 때문에
	}// o end
	fetch(`/2024h_web1/day03/example3`, option);
	
}

const func11 = () => {
	let object = {data1 : '강호동' , data2 : 40}
	const option = {
		method : 'PUT',
		header : {'Content-Type' : 'application/json'} ,
		body : JSON.stringify(object)
	}//o end
	fetch(`/2024h_web1/day03/example3`, option);
}

const func12 = () => {
	
	const option = {method : 'GET'}
	fetch(`/2024h_web1/day03/example5`, option)
		//.then((data) => {console.log(data)}) 확인할때
		.then( response =>response.json())
		.then(data => {console.log(data);})
	
}// f end

const func13=() =>{
	
	const option = {method : 'POST'}
	fetch(`/2024h_web1/day03/example5`, option)
		.then(response => response.text()) //통신성공시
		.then(data => {console.log(data)})
		.catch(data => {console.log(data)})// 통신실패시
}// f end

const func14 = () =>{
	
	const option = {method : 'POST'}
	fetch(`/2024h_web1/day03/example5`, option)
		.then(response => response.json())
		.then(data => {console.log(data);})
		.catch(error => {console.log(error);}) 
	
}//f end


const func15 = ( ) => {
	const option = { method : 'DELETE' }
	fetch(`/2024h_web1/day03/example5` , option )
		.then( r => r.json() )
		.then( data => { console.log(data ); } )
		.catch( e => { console.log(e); } )
}



/*

 fetch(`HTTP URL` , {옵션})
 	URL
	  1. 통신할 서블릿의 URL 주소
	  2. 쿼리스트링
	옵션
	  1. METHOD
	 	- GET : fetch(`HTTP URL` , {method: `GET`})
			-> GET METHOD는 기본값이므로 생략이 가능하다.
		
		- POST : fetch(`HTTP URL` , {method: `POST`})
		- PUT : fetch(`HTTP URL` , {method: `PUT`})
		- DELETE : fetch(`HTTP URL` , {method: `DELETE`})
	  2. HEADER
	  	- { 'Content-Type' : 'application/json'}
	  3. BODY :
	  	- 전송할 데이터 자료
			1. 응답객체 : 통신한 응답의 정보가 담긴 
		
	then()
		1. 응답객체 : 통신한 응답의 정보가 담긴 HTTP 응답 객체 반환
			then(응답객체명 => 응답객체명.json()) : resoponse content - type : application 
		
	[참고1 : 백틱]
		``: 백팀 템플릿: 문자열 사이에 변수/함수 호출과 연산식을 넣을 수 있는 템플릿
		`문자열 ${변수명} 문자열 ${함수명()} 문자열 ${연산}`
		
	[참고2 : JSON 문자열 타입변환]
		1. JSON.parse()			:문자열타입 --> 
		
*/