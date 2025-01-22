<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<div>대기명단</div>
		사람수    : <input class="peopleInput"/><br/>
		핸드폰번호 : <input class="ponnumberInput"/><br/>
			<button onclick = "waitingWrite()" type="button"> 등록 </button>
	</div>

	<div>방문록 목록</div>
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>people</th>
				<th>ponnumber</th>
				<th>etc</th>
			</tr>
		</thead>
	</table>
	
	<script src="task2.js"></script>
	
</body>
</html>