<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<div>
			<label="name">제목</label>
			<input type="text" id="name" name="name" class="form-control col-4">	
		</div>
		<div>
			<label="url">주소</label>
			<input type="text" id="url" name="url" class="form-control col-4">	
		</div>
		<input type="button" id="addBtn" value="추가" class="btn btn-success"> 
	</div>
	
	<script>
		$(document).ready(function() {
			$("#addBtn").on('click', function() {
				
				let name = $("#name").val();
				if(name.length < 1) {
					alert("이름을 입력하세요");
					return;
				}
				
				let url = $("#url").val();
				if(url.length == "") {
					alert("주소 입력하세요");
					return;
				}
				
				console.log(name);
				console.log(url);
				
				$.ajax({
					type:"POST"
					, url:"lesson06/quiz01/add-bookmark"
					, data:{"name":name, "url":url}
					,success:function(data) {
						alert(data);
						if(data == "성공") {
							location.href = "/lesson06/quiz01/after-add-bookmark-view";
						}
					}
					, error:function(request, status, error) {
						alert(request);
						alert(status);
						alert(error);
					}
				});
			});
		});
	
	
	</script>
</body>
</html>