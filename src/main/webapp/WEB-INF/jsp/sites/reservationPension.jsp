<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />	
	<link rel="stylesheet" type="text/css" href=/css/listStyle.css>
</head>
<body>


	<div class="container">
		<header>
			<h1>통나무 펜션</h1>
			<nav>
                <ul class="nav nav-fill">
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">팬션소개</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">예약안내</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">커뮤니티</a></li>
                </ul>
            </nav>
		</header>
				<h1>예약하기</h1>
			
		<div class="form-group">
			<label for="name">이름</label>
				<input type="text" id="name" class="form-control col-8">
		</div>
		<div class="form-group">
			<label for="date">예약날짜</label>
				<input type="text" id="date" class="form-control col-8">
		</div>
		<div class="form-group">
			<label for="day">숙박일수</label>
				<input type="text" id="day" class="form-control col-8">
		</div>
		<div class="form-group">
			<label for="headcount">숙박인원</label>
				<input type="text" id="headcount" class="form-control col-8">
		</div>
		<div class="form-group">
			<label for="phoneNumber">전화번호</label>
				<input type="text" id="phoneNumber" class="form-control col-8">
		</div>
		
		
		
		
		
		<button id="joinBtn" type="button" class="btn btn-warning col-8">예약하기</button>
			 <footer>
                <div class="address m-3">
                    제주특별자치도 제주시 애월읍<br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
                    Copyright 2025 tongnamu. All right reserved.
                </div>
           </footer>
	</div>
	
	<script>
	$(document).ready(function() {
		$('#date').datepicker({
			  dateFormat: 'yy-mm-dd',
			  minDate: 0
		});
		
		$('#joinBtn').on('click', function() {
			let date = $('#date').val().trim();
			
			$.ajax({
				type:"POST"
				,url: "/log/addData"
				,data: {"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
				
				,success: function(data) {
					location.href ="/log/pensionList"
				}
				,error:function(e) {
					alert("error" + e)
				}
				
				
			});
			
		});
		
		
	});
	
	
	
	</script>
	
	
	
	
</body>
</html>