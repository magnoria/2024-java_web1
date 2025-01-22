
//[1] 게시물 등록
const boardWrite = () => {
	//1. input DOM 가져오기
	let writerInput = document.querySelector('.writerInput')
	console.log(writerInput);
	let pwdInput = document.querySelector('.pwdInput')
	console.log(pwdInput);
	let titleInput = document.querySelector('.titleInput')
	console.log(titleInput)
	let contentInput = document.querySelector('.contentInput')
	console.log(contentInput)
	//2. DOM 에서 value 가져오기
	let bwriter = writerInput.value;
	console.log(bwriter)
	let bpwd = pwdInput.value;
	console.log(bpwd)
	let btitle = titleInput.value;
	console.log(btitle)
	let bcontent = contentInput.value;
	console.log(bcontent)
	//3. 객체화
	let dataObj = {
		bwriter : bwriter , bpwd : bpwd,
		btitle : btitle , bcontent : bcontent
		
	}
	console.log(dataObj)
	//4.fetch 옵션
	const option = {
		method : 'POST',
		headers : { 'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)		
	}
	console.log(option)
	//5. fetch
	fetch( '/2024h_web1/day5/board' , option)
		.then(response => response.json())
		.then(data => {
			if(data == true){alert('글쓰기성공'); location.href="/board.jsp";}
			else(alert('실패'))
			
		})
		.catch(error => {alert('시스템오류 : 관리자에게 문의'); console.log(error); })
		console.log(fetch);
	
}
