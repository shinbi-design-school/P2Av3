<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="quizSystem.dao.InqueryFormDAO" %>
<%@ page import="quizSystem.dto.InqueryFormDTO" %>
<%@ page import="java.util.List" %>
   
<%
int userid = (Integer)session.getAttribute("userid");
InqueryFormDAO dao = new InqueryFormDAO();
List<InqueryFormDTO> list = dao.queryAnswer(userid);
%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問い合わせ状況の確認</title>
</head>
<body>
	<h1>問い合わせ状況の確認</h1>
		<table border="1">
			<% for(int i=0; i<list.size();i++) { %>
						<tr>
							<th>問い合わせId</th>
							<th>ユーザーId
							<th>アカウント名</th>
							<th>メールアドレス</th>
							<th>問い合わせ内容</th>
							<th>返答内容</th>
						</tr>
						<tr>
							<td><%=list.get(i).getId() %></td>
							<td><%=list.get(i).getUserid()%></td>
							<td><%=list.get(i).getAccountname()%></td>
							<td><%=list.get(i).getMailaddress()%></td>
							<td><%=list.get(i).getQuery()%></td>
							<td><%=list.get(i).getReply()%></td>
						
						</tr>
						<% } %>			
	
	</table>

</body>
</html>