<%@ page language="java" contentType="text/html; charset=UTf-8" pageEncoding="UTF-8" %>

	<%
		String error = (String)request.getAttribute("error");
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTf-8">
<title>ログイン成功</title>
</head>
<body>
ログインがせいこうしました！
<p><a href="/login/Accountcheck"><button type="button" name="aaa">ユーザー or 管理者ページへ</button></a></p>
</body>
</html>