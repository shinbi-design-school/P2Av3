<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>ログイン画面</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<!-- 入れるならhead.jspをいれる -->
</head>
<body>
	<header>
		<h2>＜ログイン画面＞</h2>
	</header>
<!-- 入れるならheader.jspをいれる -->
	<main>

			<form method="post" action="LoginServlet">

				<table id="login">
					<tr>
						<th>アカウント名</th>
						<td><input type="text" name="accountname" maxlength="" /></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" name="password" maxlength="10"/></td>
				
					</tr>
					<tr>
						<td><input id="submit" type="submit" value="ログイン"></td>
					</tr>
				</table>
			</form>
			<a type="submit"  href="NewMemberAdd.jsp">新規登録</a>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
	</body>
</html>