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
</head>
<body>
	<div class="container">
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="result" items="${result}" varStatus = "status">
				<tr>
					<td>${result.id}</td>
					<td>${result.name}</td>
					<td>${result.url}</td>
					<%-- name 속성과 value 속성을 이용하는 방식은 가능하면 쓰지말자, value에는 딱 한개의 값만을 담을 수 있기 때문에 범용성이 좋지 않다 --%>
					<%-- 권장하는 방법: data를 이용하여 태그에 data를 임시 저장하기, data의 이름 지을 땐 무조건 하이픈(-)으로 이름짓자 --%>
					<td><button type="button" class="btn btn-danger btn-block col-8 del-btn" data-farvorite-id="${result.id}">삭제</button></td>
				</tr>
				</c:forEach>
			</tbody>
			
			
		</table>
	
	
	</div>
	
	<script>
		$(document).ready(function() {
			//태그:data-farvorite-id data- 그 뒤부터는 우리가 이름을 정한다.(카멜[abcId,같은 형식] 절대 안됨)
			
			$('.del-btn').on('click', function() {
				//스크립트: $(this).data('') 태그에 심은 값을 꺼냄
				let id = $(this).data('farvorite-id'); //data- 는 뺀다/
				console.log(id);
				
				$.ajax({
					type: "POST"
					,url: "/lesson06/del_List"
					,data: {"id": id}
				
				//response
				,success: function(data) {
					if(data.result == "success") { //data.result값 확인
						location.reload(true); //새로고침
					}	 	
				} 
				,error: function(e) {
					alert("삭제 실패")
				}
	
				}); 
				
			});
			
			
			
		});
	
	
	
	</script>

	



</body>
</html>