<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:include page ="/day05/header.jsp"></jsp:include>
		
		<div>
			<h3>게시판 : 커뮤니티를 제공합니다.</h3>
			<a href ="/2024h_web1/day05/write.jsp"> 글쓰기 </a>
			<!--<button onclick="location.href='/2024h_web1/day05/write.jsp'"></button>  -->
			<table>
				<thead border="1">
					<tr>
						<th>번호</th><th>제목</th><th>작성일</th><th>작성자</th><th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>1</th><th><a href="view.jsp?bno=1">안녕하세요1</a></th>
						<th>2025-01-11:09:05</th><th>유재석</th><th>30</th>
					</tr>
					<tr>
						<th>2</th><th><a href="view.jsp?bno=2">안녕하세요2</a></th>
						<th>2025-01-11:09:05</th><th>강호동</th><th>4</th>
					</tr>
				</tbody>
			</table>
			
		</div>
		
		<jsp:include page ="/day05/footer.jsp"></jsp:include>
	
</body>
</html>