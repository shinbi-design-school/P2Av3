<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>ログイン画面</title>
	<!-- 入れるならhead.jspをいれる -->
</head>
<body>
	<h1>ログイン画面</h1>
<!-- 入れるならheader.jspをいれる -->
		<main>
			<form method="post" action="http://localhost:8080/P2Av3/LoginServlet_momose">
				<table id="login">
					<tr>
						<th>アカウント名</th>
						<td><input type="text" name="account" maxlength="" /></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" name="password" maxlength=""/></td>
					</tr>
					<tr>
						<td><input id="submit" type="submit" value="ログイン"></td>
					</tr>

				</table>
			</form>
			<a type="submit" type="submit" href="http://localhost:8080/P2Av3/NewMemberAdd.jsp">新規登録</a>
		</main>
	<!-- 入れるならfooter.jspをいれる -->
	</body>
</html>