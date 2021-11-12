<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>エラー</title>
	</head>
	<body>
		<header>
			<h1>エラー画面</h1>
		</header>
		<main>
			<%
			 String errorMessage = (String)session.getAttribute("errorMessage");
			%>
			<div id="error">
				<%=errorMessage %>
			</div>
		</main>
		<footer>
			<jsp:include page="footer.jsp"/>
		</footer>
	</body>
</html>