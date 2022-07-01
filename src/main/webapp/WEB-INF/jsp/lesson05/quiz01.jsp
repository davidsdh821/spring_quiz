<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>1. JSTL core 변수</h1>
	<c:set var="num1" value="36" />
	<c:set var="num2" value="5" />
	<h3>첫번째 숫자 :${num1}</h3> 
	<h3>두번째 숫자 :${num2}</h3> 
	
	<h1>3. JSTL core out</h1>
	<c:out value="<title>core out</title>"/>
	
	<h1>5. JSTL core if</h1>
	<c:if test="${(num1 * num2)  > 100}">
		<c:out value="<script>alert('너무 큰 수 입니다')</script>" escapeXml="false"/>
	</c:if>
	
</body>
</html>