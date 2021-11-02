<%@ page language="java" contentType="text/html; charset=UTf-8" %>

<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報</title>
</head>
<body>
ここはユーザーページです。<br>
<input type="${account.role == 2 }">
登録内容の確認。<br>
<p>ログインID：<input value="${account.loginId }"></p>
<p>パスワード：<input value="${account.pass }"></p>
<p>　　　名前：<input value="${account.name }"></p>
<p>　　ロール：ユーザー</p>
<p><a href="/loginServlet/LogoutServlet"><button type="button" >ログアウト</button></a></p>
<a href="admin.jsp"><button type="button" >管理者ページへ</button></a>

<input type="${account.role == 1 }">
<a href="admin.jsp">管理者ページへ</a>
<a href="login.jsp">ログインページへ</a>
</body>
</html>