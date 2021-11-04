<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>エラー</title>
	</head>
	<body>
		<h1>エラー画面</h1>
		<main>
			<%
			 String errorMessage = (String)session.getAttribute("errorMessage");
			%>
			<div id="error">
				<%=errorMessage %>
			</div>
		</main>
	</body>
</html>