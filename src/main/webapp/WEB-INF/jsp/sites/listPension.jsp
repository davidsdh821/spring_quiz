<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>예약 목록 보기</h1>
		<table class="table text-center">
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
			<c:forEach var="result" items="${result}">
				<tr>
					<%-- <td class ="d-none">${result.id}</td> --%>
					<td>${result.name}</td>
					<td><fmt:formatDate value="${result.date}" pattern="yyyy년 MM월 dd일" var="pattern"/> 
						${pattern}</td>
					<td>${result.day}</td>
					<td>${result.headcount}</td>
					<td>${result.phoneNumber}</td>
					<c:choose>
					<c:when test="${result.state eq '대기중'}">
					<td class="text-primary">${result.state}</td>
					</c:when>
					
					<c:otherwise>
						<td class="text-success">${result.state}</td>
					</c:otherwise>
					</c:choose>
					<td><button type="button" class="btn btn-danger btn-block del-btn col-8" data-pension-id="${result.id}">삭제</button></td>
					
				</tr>
				</c:forEach>
			</tbody>

		</table>
		
		 <footer>
                <div class="address m-3">
                    제주특별자치도 제주시 애월읍<br>
                    사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
                    Copyright 2025 tongnamu. All right reserved.
                </div>
           </footer>
		

	</div>
	
	<script>
		$(document).ready(function () {
			$('.del-btn').on('click', function() {
				let id = $(this).data('pension-id');
				console.log(id);
				
				
				$.ajax({
					type:"POST"
					,url: "/log/del_btn"
					,data:{"id": id}
					
					,success: function(data) {
						if(data.del =="success") {
							location.reload(true);
						}
					}
					,error: function(e) {
						alert("삭제실패");
					}
									
				
				
				});
				
				
				
			});
			
	
			
			
		});
			
		
	</script>
	
	


</body>
</html>