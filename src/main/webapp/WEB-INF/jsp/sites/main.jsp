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

	<link rel="stylesheet" href="/css/mainStyle.css">	
</head>
<body>
	
<div id="wrap" class="container">
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
            <section class="banner bg-info">
                <img id="bannerImage" src="http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg" alt="banner" width="1110px" height="500px">
            </section>
            <section class="reserve bg-primary d-flex">
                <section class="real-time-reserved col-4 d-flex justify-content-center align-items-center">
                    <div class="display-4 text-white">실시간<br>예약하기</div>
                </section>
                <section class="confirm col-4">
             	
						<h2 class="text-white">예약확인</h2>
                        <div class="d-flex justify-content-end mr-3">
                            <span class="text-white">이름:</span>
                            <input type="text" id="name" class="form-control input-form">
                        </div>
                        <div class="d-flex mt-2 justify-content-end mr-3">
                            <span class="text-white">전화번호:</span>
                            <input type="text" id="phoneNumber" class="form-control input-form">
                        </div>

                        <!-- 버튼 -->
                        <div class="text-right mt-3">
                            <button id="resevBtn" type="button" class="btn btn-success submit-btn">조회 하기</button>
                        </div> 


                </section>
                <section class="inquiry col-4 d-flex justify-content-center align-items-center">
                    <div class="text-white">
                        <h4 class="font-weight-bold">예약문의:</h4>
                        <h1>010-<br>0000-1111</h1>
                    </div>
                </section>
            </section>
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
            	$('#resevBtn').on('click', function() {
            		let name = $('#name').val().trim();
            		let phoneNumber = $('#phoneNumber').val().trim();
            		console.log(name);
            		console.log(phoneNumber);
            		if(name =="") {
            			alert("이름 입력하세요");
            			return;
            		} 
            		
            		if(phoneNumber == "") {
            			alert("전화번호 입력하세요");
            			return;
            		}
            		
            		
            		$.ajax({
        				type:"POST"
        				,url: "/log/selectData"
        				,data: {"name":name, "phoneNumber":phoneNumber}
        				
        				,success: function(data) {
        					if(data.pension.name == "" ) {
        						alert("예약 내역이 없습니다");
        					} else {
        						alert("이름:" + data.pension.name + "\n"
            							"날짜:" + data.pension.date.substring(0, 10) + "\n"
            							"일수:" + data.pension.day + "\n"
            							"인원" + data.pension.headcount + "\n"
            							"상태" + data.pension.state 
            					);
        					}
        						
        					
        					}
        					
        					
        				}
        				,error:function(e) {
        					alert("error" + e)
        				}
        				
        				
        			});
            		
            		
            		
            	});
            	
            	
            	
            	
            	   var bannerSrcArr = ['http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner1.jpg', 
            		   'http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner2.jpg', 
            		   'http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner3.jpg', 
            		   'http://marondal.com/material/images/dulumary/web/front/jquery/test06_banner4.jpg'];
                   var currentIndex = 0;
                   setInterval(function() {
                       $('#bannerImage').attr('src', bannerSrcArr[currentIndex]);
                       currentIndex++;

                       if (currentIndex > bannerSrcArr.length) { // 인덱스 값이 배열의 크기를 넘으면 0으로(처음 이미지) 세팅
                           currentIndex = 0;
                       }
                   }, 3000);
            });
		</script>

</body>
</html>