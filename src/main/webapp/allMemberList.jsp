<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="quizSystem.dto.LoginDTO" %>
   
<%
List<String> memberList= (List<String>)session.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mebmberDeleteAfterUsers</title>
</head>
<body>
<body>
	<h1>全ユーザーリスト</h1>
<!-- 入れるならheader.jspをいれる -->
		<main>
			<form method="post" action="●●">
				<table border="1" id="●●">
					<% for(int i=0; i<memberList.size()/3;i++) { %>
					<tr>
						<th>Id</th>
						<th>アカウント名</th>
						<th>ハッシュ化パスワード</th>
					</tr>
					<tr>
						<td><%=memberList.get(3*i+0)%></td>
						<td><%=memberList.get(3*i+1) %></td>
						<td><%=memberList.get(3*i+2) %></td>
					
					</tr>
					<% } %>	
					<tr>
						<td><a href="AdministratorScreen.jsp">管理者画面に戻る</a></td>
					</tr>
				</table>
			</form>
		</main>
</html>