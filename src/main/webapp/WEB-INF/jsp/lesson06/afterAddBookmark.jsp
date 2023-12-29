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
		<h1>즐겨찾기목록</h1>
		<table>
			<tr>
				<th>No.</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
			<tr>
				<td>#{id}</td>
				<td>#{name}</td>
				<td>#{url}</td>
			</tr>
		</table>
	
	</div>
</body>
</html>