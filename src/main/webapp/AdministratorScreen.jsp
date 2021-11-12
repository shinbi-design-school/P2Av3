<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" type="text/css" href="css/AdministratorScreen.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>管理者画面</h1>
	</header>
	<main>
			<h3 id="member">1,<a href="MembersServlet">現在ログインできる登録したメンバーを確認する。</a></h3>
			<h3 id="login">2,<a href="login.jsp">ログインする</a></h3>
			<h3 id="memberAdd">3,<a href="NewMemberAdd.jsp">メンバー登録する</a></h3>
			<h3 id="delete">4,<a href="memberDelete.jsp">メンバーを削除する</a></h3>
			<h3 id="">5,<a href="">お客さんからの問い合わせ依頼を見る。</a></h3>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
</body>
</html>