

const boardView = () => {
	
	// 1. 현재 URL의 쿼리스트링 매개변수를 가져온다.
		// *내가 board.jsp 에서 클릭한 게시물 번호가 존재하면 쿼리스트링
		
	let bno = new URL(location.href).searchParams.get('bno');
	
	// 2. fetch 옵션
	const option = { method : 'GET'}
	
	// 3. fetch 텅신
	fetch(`/2024h_web1/day05/board/view?bno=${bno}` . option)
		.then(response => response.json())
		.then(data => {
			
		document.querySelector('.bdatebox').innerHTML = `${data.bdate}`
		document.querySelector('.bwriterbox').innerHTML = `${data.bwriterbox}`
		document.querySelector('.bviewbox').innerHTML = `${data.bviewbox}`
		document.querySelector('.btitlebox').innerHTML = `${data.btitlebox}`
		document.querySelector('.bcontentbox').innerHTML = `${data.bcontentbox}`
			
		})
		.catch(error => {console.log(error)})
	
}// c end
boardView(); //JS가 열릴때 최초 실행