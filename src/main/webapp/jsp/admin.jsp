<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ページ</title>
</head>
<body>
ここは管理者用のページです。<br>
<c:choose>
<c:when test="${account.role == 1 }">
登録内容の確認。<br>
<p>ログインID：<c:out value="${account.loginId }"></c:out></p>
<p>パスワード：<c:out value="${account.pass }"></c:out></p>
<p>名前：<c:out value="${account.name }"></c:out></p>
<p>ロール：管理者</p>
<p><a href="/login/Logout"><button type="button" >ログアウト</button></a></p>
<a href="user.jsp"><button type="button" >ユーザーページへ</button></a>
</c:when>
<c:when test="${account.role == 2 }">
<a href="user.jsp">ユーザーページへ</a>
</c:when>
<c:otherwise>
<a href="login.jsp">ログインページへ</a>
</c:otherwise>
</c:choose>
</body>
</html>