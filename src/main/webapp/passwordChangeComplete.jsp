<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
 
 <%
 List<String> afterUser = (List<String>)session.getAttribute("afterUser");
 %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更画面</title>
</head>
<body>
	<header>
		<h1>パスワード変更画面</h1>
	</header>
	<main>
		<h2>パスワードの変更が完了しました。</h2>
				<table id="password変更完了">
					<tr>
						<th>Id：<%=afterUser.get(0) %></th>
					</tr>
					<tr>
						<th>アカウント名：<%=afterUser.get(1) %></th>
					</tr>
					<tr>
						<th>パスワード：<%=afterUser.get(2) %></th>
					</tr>
					<tr>
						<th>ハッシュ化パスワード：<%=afterUser.get(3) %></th>
					</tr>
					
					<tr>
						<td><a  href="login.jsp">ログイン画面へ戻る</a></td>
					</tr>
				</table>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
</body>
</html>