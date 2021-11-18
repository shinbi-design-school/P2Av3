<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quizSystem.dao.InqueryFormDAO" %>
<%@ page import="quizSystem.dto.InqueryFormDTO" %>
<%@ page import="java.util.List" %>

    
<%
InqueryFormDAO dao = new InqueryFormDAO();
List<InqueryFormDTO> list = dao.inqueryAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>問い合わせの内容全て</title>
</head>
<body>
	<h1>問い合わせ内容</h1>
	<h3>お客さんから届いている問い合わせの全て</h3>
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
	<h1>返答内容を記載する</h1>
	<form method="post" action="InqueryFormReplyServlet">
     <table>
     	 <tr>
          <th><label for="quesryId">問い合わせId</label></th>
          <td><input id="queryId" name="queryId" type="text" required></td>
        </tr>
        <tr>
          <th><label for="userid">ユーザーId</label></th>
          <td><input id="userid" name="userid" type="text" required></td>
        </tr>
        <tr>
          <th><label for="accountname">アカウント名</label></th>
          <td><input id="accountname" name="accountname" type="text" required></td>
        </tr>
        <tr>
          <th><label for="email">メールアドレス</label></th>
          <td><input id="email" name="email" type="email" required></td>
        </tr>
        <tr>
         <th>
          <label for="remarks_text">返答内容</label>
         </th>
          <td><textarea id="remarks_text" name="reply" rows="8" ></textarea></td>
        </tr>
		<tr>
		 <th>確認</th>
		 <td><input id="confilm_check" name="confilm" type="checkbox" required>上記の入力に間違いないことを確認しました。</td>
		</tr>
		<tr>
		  <td colspan="2">
		  <input type="reset" value="やり直し">
		  <input type="submit" name="method" value="送信する"></td>
		</tr>
		</table>
		</form>

<a href="AdministratorScreen.jsp">管理者画面に戻る</a>

</body>
</html>