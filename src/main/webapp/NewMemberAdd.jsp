<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>新規ユーザー登録</title>
	<!-- 入れるならhead.jspをいれる -->
</head>
<body>
	<header>
		<h1>新規ユーザー登録</h1>
	</header>
	<main>
			<form method="post" action="http://localhost:8080/P2Av3/NewMemberRegisterServlet">
				<table id="NewMemberAdd">
					<tr>
						<th>アカウント名</th>
						<td><input type="text" name="accountname" maxlength="" /></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" name="password" maxlength=""/></td>
					</tr>
					<tr>
						<td><input id="submit" type="submit" value="登録する"></td>
					</tr>
					<tr>
						<td><a href="http://localhost:8080/P2Av3/login.jsp">ログイン画面に戻る</a></td>
					</tr>
				</table>
			</form>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
</html>