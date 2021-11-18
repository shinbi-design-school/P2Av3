<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quizSystem.dto.InqueryFormDTO" %>
<%
InqueryFormDTO dto = (InqueryFormDTO)session.getAttribute("dto");
%>    
    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>問い合わせ完了画面</title>
	
</head>
<body>
	<h1>問い合わせ完了</h1>
	<h3>以下の内容について管理者へ問い合わせいたしました。返答まで少々お時間頂きますようお願い申し上げます。</h3>
	
	<table border="1">
		<tr>
			<th>ユーザーid</th>
			<th>アカウント名</th>
			<th>メールアドレス</th>
			<th>問い合わせ内容</th>
		</tr>
		<tr>	
			<td><%=dto.getUserid() %></td>
			<td><%=dto.getAccountname() %></td>
			<td><%=dto.getMailaddress() %></td>
			<td><%=dto.getQuery() %></td>
			
	
	</table>
</body>
</html>