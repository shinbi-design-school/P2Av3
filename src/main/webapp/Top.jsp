<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>トップ画面</title>
		<style>
			h1 {
				margin-bottom: -10px;
			}
			h3 {
				text-align: center;
			}
			
			header {
				margin-top: -50px;
			}
		</style>
	</head>
	<body>
		<header>
			<h1>トップ画面</h1>
		</header>
		<main>
			<h3><a href="SelectQuiz.jsp">＜ログインせずにクイズへ進む＞</a></h3>
			<jsp:include page="login.jsp"/>
		</main>
		<footer>
		</footer>
	</body>
</html>