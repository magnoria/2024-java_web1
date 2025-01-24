

//[수정 하기 전 정보를 조회] 게시물 개별 조회
const boardView = ( ) => {
	// 1. 현재 URL의 쿼리스트링 매개변수 가져온다. day25 수업 참고.
		// * 내가 board.jsp 에서 클릭한 게시물 번호가 존재하면 쿼리스트링 
		// http://localhost:8080/tj2024b_web1/day05/view.jsp?bno=3
		// http://localhost:8080/tj2024b_web1/day05/view.jsp?bno=2
		// http://localhost:8080/tj2024b_web1/day05/view.jsp?bno=10
	let bno = new URL( location.href ).searchParams.get('bno');
	
	// 2. fetch 옵션 
	const option = { method : 'GET' }
	// 3. fetch 통신 
	fetch( `/2024h_web1/day05/board/view?bno=${ bno }` , option )
		.then( response => response.json() )
		.then( data => {
			// 4. fetch 응답에 따른 화면 출력 
					//마크업 주요 속성
						//1. innerHTML : 시작 마크업과 끝마크업 사이에 <마크업>여기</마크업> HTML 문자열 호출및 대입 가능
							// --> div ,span, table 등등 , 불가능 : <input/> <img/>
						//2. value : 마크업의 입력 속성값 <마크업 value=""/> 대입/호출
							//--> input, select ,textarea , 불가능 : 레이아웃 div, span, table 등등
			document.querySelector('.titleInput').value = `${ data.btitle }`
			document.querySelector('.contentInput').value = `${ data.bcontent }`
			//이 값을 복사해온값 그대로 복사해옴 뭐엇이 들어가고 무엇인지 확인할것
			
		})
		.catch( error => { console.log(error) })
} // f end 
boardView() ; // JS가 열릴때 최초 실행

//[수정처리]
const boardUpdate = () => {
	//1. 수정할 게시물 번호
	let bno = new URL( location.href).searchParams.get('bno');
	console.log(bno)
	//2. input DOM 객체 가져오기
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	//3. 가져온 DOM 객체로 부터 value(입력값속성) 값 가져오기
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	//4. 객체화
	let dataObj = {bno : bno , btitle : btitle , bcontent : bcontent}
	//5.fetch
	const option = {
		method : 'PUT',
		Headers : {'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
		
	}// o end
	
	// 
	fetch('/2024h_web1/day05/board' , option)
		.then(response => response.json())
		.then(data => {
			if(data == true){
				alert('수정성공');
				location.href=`view.jsp?bno=${bno}`;
			}else{alert("수정실패");}
			
		})
	
}// f end

