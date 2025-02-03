<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	<!-- 부트스트랩 링크 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	 <!-- 내가 만든 css -->
	 <link href="/2024h_web1/css/index.css" rel="stylesheet">
</head>
<body>
	
		<nav class="navbar navbar-expand-lg">
	  <div class="container"><!-- container : 반응형(크기) 구역/박스 -->
	  
	    <a class="navbar-brand" href="/2024h_web1/index.jsp"><!-- 주로 로고 -->
   			<img class="header_logo" src="/2024h_web1/img/Logo.jpg" />
	    </a>
	    
	    <!-- 반응형 토큰(버튼) : 디바이스가 작아지면 메뉴를 보여주는 버튼 활성화 -->
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    
	    <!-- 메뉴 -->
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    
	    	<!--  메뉴 목록 -->
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	      
	      
	        <!-- 메뉴 항목 -->
	        <li class="nav-item">
	          <a class="nav-link" href="#">게시판</a> </li>
	        
	        
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            제품
	          </a>
	          <ul class="dropdown-menu">
	            <li><a class="dropdown-item" href="#">Action</a></li>
	            <li><a class="dropdown-item" href="#">Another action</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
	        
	      
	      </ul>
	  
	  		  <ul class="navbar-nav me-end mb-2 mb-lg-0 loginmenu"><!-- end 오른쪽정렬 -->
	  		 
	       		 
	  		
	  		</ul>   
	    </div>
	  </div>
</nav>



	<!-- 부트스트랩 JS  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<!-- header JS -->
	<script src="/2024h_web1/js/header.js"></script>
</body>
</html>