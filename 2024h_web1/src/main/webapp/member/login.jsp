<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="/header.jsp"></jsp:include>
	
	
	
	<!-- 회원가입폼 -->
  <div class="container col-xl-10 col-xxl-8 px-4 py-5">
    <div class="row align-items-center g-lg-5 py-5">
    
    <!-- 왼쪽 메시지 구역 -->
      <div class="col-lg-7 text-center text-lg-start">
        <h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3"> 더조은 WEB SIGNUP PAGE</h1>
        <p class="col-lg-10 fs-4"> 다양한 서비스를 제공합니다. </p>
      </div>
      
      <!-- 오른쪽 회원가입 구역 -->
      <div class="col-md-10 mx-auto col-lg-5">
      
        <form class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
        			<!-- signup오타가 있었음 -->
        	
        	<!-- 아이디 -->
          <div class="form-floating mb-3"> <!-- id 속성은 마크업당 1번만 가능, class 속성은 마크업당 여러개 가능, 띄어쓰기로 구분 -->
            <input type="text" class="form-control midinput" class="form-control" id="floatingInput1" placeholder="계정아이디"><!-- 입력전가이드 -->
            <label for="floatingInput"> 계정아이디</label>
          </div>
          
          <div class="form-floating mb-3">
            <input type="password" class="form-control mpwdinput" class="form-control" id="floatingPassword2" placeholder="계정비밀번호">
            <label for="floatingPassword"> 계정비밀번호</label>
          </div>
          
          
          
          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onLogin()">로그인</button>
          <hr class="my-4">
          <small class="text-body-secondary"><a class="nav-link" href="signup.jsp">회원가입</a></small>
          <small class="text-body-secondary"><a class="nav-link" href="#">아이디찾기</a></small>
          <small class="text-body-secondary"><a class="nav-link" href="#">비밀번호찾기</a></small>
        </form>
        
      </div>
    </div>
  </div>
  
  <script type="text/javascript" src="/2024h_web1/js/member/login.js"></script>
							<!-- 여길 수정안해서 login jsp가 실행이 안됬고 오류가 떳었음 -->
</body>
</html>