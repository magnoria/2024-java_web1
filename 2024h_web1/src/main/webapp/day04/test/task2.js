

const waitingWrite = () => {
		console.log('함수 실행했다.');
	let peopleInput = document.querySelector('.peopleInput')
		console.log(peopleInput);
	let ponnumberInput = document.querySelector('.ponnumberInput')
		console.log(ponnumberInput);
		
	let people = peopleInput.value;
	let ponnumber = ponnumberInput.value;
	
	let dataObj = {'people' : people , 'pnnumber' : ponnumber };
	
	let option = {
		method : 'POST' ,
		header : { 'Content-Type' : 'application/json'},
		body : JSON.stringify(dataObj)
	}// o ebd
	
	fetch('/2024h_web1/day3/waiting2', option)
		.then(r => r.json())
		.then(data => {
			
			if(data == true){alert('등록성공'); waitingFindAll();}
			else{alert('등록실패');}
		})
		.catch(e => {console.log(e);})
	
}// c end


