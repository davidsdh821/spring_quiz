<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 	<h1>즐겨찾기 추가하기</h1>
		<form method="post" action="/lesson06/quiz01_2">
		 <div class="form-group">
 				<label for="name">제목</label>
 				<input type="text" id="name" name="name" class="form-control" placeholder="제목을 입력하세요">
 		</div>
		<div class="form-group">
			<label for="url">URL 주소</label>
			<div class ="d-flex">
				<input type="text" id="url" class="form-control col-8">
				<button type="button" class="btn btn-info" id="checkDuplicateBtn">중복확인</button>
			</div>
			<small id="duplicationText" class="text-danger d-none">중복된 url</small>
			<small id="availableUrlText" class="text-success d-none">저장가능한 url 입니다.</small>
		</div>
 		

		 <input type="button" id="addBtn" class="btn btn-success btn-block" value="추가">
		
		
		</form>
	</div>
	<script>
	$(document).ready(function() {
		$('#checkDuplicateBtn').on('click',function() {
			let url =$('#url').val().trim();
			console.log(url);
			
			if(url == "") {
				alert("URL을 입력하세요.");
				return;
			}
			//중복확인 ajax통신 - db확인
			$.ajax({
				//request
				type: "POST"
				,url: "/lesson06/is_duplication_url" //주의 ajax를 보내는 주소에는 view를 붙이지 않는다.
				,data: {"url": url}
				//response
				, success: function(data) {
					if (data.is_duplication) {
						//중복일 때
						$('#duplicationText').removeClass('d-none');
						$('#availableUrlText').addClass('d-none'); //켜지면 반대 것은 꺼지게 하기 위해서 넣어야 한다
					} else {
						$('#availableUrlText').removeClass('d-none');
						$('#duplicationText').addClass('d-none');
					}
				}
				, error: function(e) {
					alert("중복검사에 실패했습니다/")
				}
				
			});
		});
		
		
		$("#addBtn").on('click', function() {
			let name =  $('#name').val().trim();
	 			if (name == "") {
	 					alert("제목을 입력해주세요");
	 					
	 				return; 	
	 		}
			let url =  $('#url').val().trim();
	 			if (url == "") {
	 					alert("주소를 입력해주세요");
	 					
	 				return; 	
	 		}	
	 			//http도(그리고)https도 아닐 때 =>alert 알림.
	 			if(url.startsWith("http") === false && url.startsWith("https") === false) { // ===은 타입까지 검사
	 				alert("주소 형식이 잘못되었습니다");
	 				return;
	 			}
	 	//url 중복확인 체크
	 	// '저장가능한 url입니다' 문가가 숨겨져 있을 때 alert을 띄운다
	 	// d-none이 있을 때
	 	if($('#availableUrlText').hasClass('d-none')) { //hasClass class의 상태를 확인(d-none이 있는지 없는지)
	 		alert("URL 중복확인을 다시 해주세요");
	 		return;
	 	}
	 			
	 			
	 			
	 			
	 	//보내기
	 				$.ajax({
 	 					// request
 	 					type:"POST" //requset의 메소드
 	 					, url:"/lesson06/quiz01_2"	//Actuin URL
 	 					, data: {"name": name, "url": url } 
 	 					, success: function(data) {
 	 						alert(data);
 	 						location.href ="/lesson06/quiz01_3"
/* 							alert(data.result);
 	 						alert(data.result_code);  
 	 						두번째 방식 사용시 오류의 key를 alert으로 꺼내 쓸 수 있다*/
 	 					}
 	 					, error: function(e) {
 	 						alert("error" + e);
 	 					}
 	 					
 	 				});
			
			
		});
			
		
	});
			
		
</script>



</body>
</html>