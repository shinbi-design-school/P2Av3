<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelete</title>
</head>
<body>
	<header>
			<h1>メンバー削除画面</h1>
	</header>
	<main>
			<form method="post" action="DeleteMemberServlet">
				<table id="memberDelete">
					<tr>
						<th>削除するId</th>
						<td><input type="text" name="deleteId" maxlength="" /></td>
					</tr>
				
					<tr>
						<th>削除するアカウント名</th>
						<td><input type="text" name="deleteAccountname" maxlength="" /></td>
					</tr>
					<tr>
						<th>削除するパスワード</th>
						<td><input type="password" name="deletePassword" maxlength=""/></td>
					</tr>
					<tr>
						<td><input id="submit" type="submit" value="入力したメンバーを削除する。"></td>
					</tr>

				</table>
			</form>
			<a type="submit" type="submit" href="AdministratorScreen.jsp">管理者の画面に戻る</a>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
	</body>
</html>