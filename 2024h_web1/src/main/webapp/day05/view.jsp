<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/day05/header.jsp"></jsp:include>


	<div>
		<h3> 게시물 개별 조회 : 상세페이지로 선택한 특정 게시물을 조회합니다.</h3>
		<div>
			<span class ="bdatebox"> 작성일 들어가는곳</span>
			<span class = "bwriterbox"> 작성자 들어가는곳</span>
			<span class = "bviewbox"> 조회수 들어가는곳</span>
			
		</div>
		<div class="btitlebox">제목이 들어가는곳</div>
		<div class="bcontentbox">내용이 들어가는곳</div>
		
		<div class = "etcbtns">
			<button onclick = "boardDelet()">삭제</button>
			<button onclick = "boardUpdate()">수정</button>
		</div>
		
	</div>
	<a href="update.jsp?bno=1">수정</a>
	<jsp:include page="/day05/footer.jsp"></jsp:include>

</body>
</html>