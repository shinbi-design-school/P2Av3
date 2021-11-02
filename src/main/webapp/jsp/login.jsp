<%@ page language="java" contentType="text/html; charset=UTf-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTf-8">
<title>ログイン画面</title>
</head>
<body>
<form action="/login/AccountSearch" method="post">
ユーザーID：<input type="text" name="loginId" required><br>
パスワード：<input type="password" name="pass" required><br>
<input type="submit" value="ログイン"><br>
</form>
	<p>
アカウント登録がお済みでない方はこちらへ↓<br>
<a href="register.jsp"><button>新規登録</button></a>
	</p>
</body>
</html>