<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quizSystem.dto.LoginDTO" %>

<%
	String[] user = (String[])session.getAttribute("user");
 %>
<html>
<head>
<title>ユーザーステータス画面</title>
</head>
<body>
<h1><%=user[1]/*status.get(1)*/ %>さんの部屋：</h1>
    <div class = "status">
    
    			<h3>Id：<%=user[0]/*status.get(0)*/%></h3>
		        <h3>アカウント名：<%=user[1]/*status.get(1)*/ %></h3>
		        <h3>ハッシュ化パスワード：<%=user[2]/*status.get(2)*/ %></h3>
	
				<table border="1">
					<tr>
						<th>クイズを解いた回数</th>
						<th>正解数</th>
						<th>回答時間</th>
					</tr>
					
					<tr>
					<!--  for文で繰り返して出力 -->
						<th>javaコード</th>
						<th>javaコード</th>
						<th>javaコード</th>
					</tr>
				</table>
    </div>
<a href="SelectQuiz.jsp">クイズの選択へ進む</a>
<p></p>
<a href="InqueryForm.html">不明点の問い合わせフォーム</a>
<p><p>
<form id="userStatus" method="post" action="PasswordChangeServlet">
<h5>パスワードを変更する<h5>
<input type="password" name="passwordChange" maxlength="10"/>
<input type="hidden" value=<%=user[0] %> name="id">
<input type="hidden" value=<%=user[1] %> name="accountname">
<input type="hidden" value=<%=user[2] %> name="passwordBytesString">
<p></p>
<input id="submit" type="submit" value="パスワードを変更する。">
</form>

</body>
</html>