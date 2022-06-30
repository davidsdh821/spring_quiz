<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>공인중개사 정보</h1>
		<table class="table">
			<tr>
				<th>ID</th>
				<th>${result.id}</th>
			</tr>
			<tr>
				<th>상호명</th>
				<th>${result.office}</th>
			</tr>
			<tr>
				<th>전화 번호</th>
				<th>${result.phoneNumber}</th>
			</tr>
			<tr>
				<th>주소</th>
				<th>${result.address}</th>
			</tr>
			<tr>
				<th>등급</th>
				<th>${result.grade}</th>
			</tr>
		</table>
		
	</div>

</body>
</html>