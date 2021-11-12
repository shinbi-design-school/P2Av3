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
	<header>
		<h2>登録完了しました。</h2>
	</header>
	<main>
				<table id="新規ユーザー登録完了">
					<tr>
						<th>Id：<%=addUser.getId()%></th>
					</tr>
					<tr>
						<th>アカウント名：<%=addUser.getAccountname()%></th>
					</tr>
					<tr>
						<th>パスワード：非表示</th>
					</tr>
						<tr>
						<th>ハッシュ化パスワード：<%=addUser.getPasswordByteString() %></th>
					</tr>
					
					<tr>
						<td><a  href="SelectQuiz.jsp">クイズの選択へ進む</a></td>
					</tr>
				</table>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
	</body>
</html>