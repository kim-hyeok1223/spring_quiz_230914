<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<%-- 내가 만든 외부 스타일시트 --%>
<link rel="stylesheet" type="text/css" href="/css/booking/style.css">
</head>
<body>
	<div id="wrap" class="container">
            <header class="d-flex justify-content-center align-items-center">
                <div class="display-4">통나무 팬션</div>
            </header>
            <nav>
                <ul class="nav nav-fill">
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">팬션소개</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">예약안내</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">커뮤니티</a></li>
                </ul>
            </nav>
            <section>
            	<h2 class="text-center p-4"><b>예약 목록 보기</b></h2>
	            <table class="table">
	            	<thead>
	            		<tr>
	            			<th>이름</th>
	            			<th>예약날짜</th>
	            			<th>숙박일수</th>
	            			<th>숙박인원</th>
	            			<th>전화번호</th>
	            			<th>예약상태</th>
	            		</tr>
	            	</thead>
	            	<tbody>
	            	<c:forEach items="${bookingList}" var="book"> 
	            		<tr>
	            			<td>${book.name}</td>
	            			<td>${book.date}</td>
	            			<td>${book.day}</td>
	            			<td>${book.headcount}</td>
	            			<td>${book.phoneNumber}</td>
	            			<td>${book.state}</td>
	            			<!--  삭제하기 버튼 만들기 부터 하자 -->
	            		</tr>
	            	</c:forEach>	
	            	</tbody>
	            </table>
            </section>
            <footer class="d-flex align-items-center pl-3">
             <small class="text-secondary">
                제주특별자치도 제주시 애월읍<br>
                사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
                Copyright 2025 tongnamu. All right reserved.
             </small>
        </footer>
     </div>       
</body>
</html>