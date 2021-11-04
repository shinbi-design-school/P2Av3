<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quizSystem.dto.NewMemberAddDTO" %>
    
<%
NewMemberAddDTO addUser =(NewMemberAddDTO)session.getAttribute("addUser");

%>
<!DOCTYPE html>
<html>
<head>
	<title>新規ユーザー登録完了画面</title>
	<!-- 入れるならhead.jspをいれる -->
</head>
<body>
<!-- 入れるならheader.jspをいれる -->
	<h2>登録完了しました。</h2>
		<main>
				<table id="新規ユーザー登録完了">
					<tr>
						<th>Id：<%=addUser.getId()%></th>
					</tr>
					<tr>
						<th>アカウント名：<%=addUser.getAccountname()%></th>
					</tr>
					<tr>
						<th>パスワード：<%=addUser.getPassword() %></th>
					</tr>
					<tr>
						<td><a  href="SelectQuiz.jsp">クイズの選択へ進む</a></td>
					</tr>
				</table>
		</main>
	<!-- 入れるならfooter.jspをいれる -->
	</body>
</html>