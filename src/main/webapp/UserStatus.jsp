<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<%
	@SuppressWarnings("unchecked")
	List<Object> status = (List<Object>)session.getAttribute("userStatus");
	System.out.println(status);
	System.out.println(status.get(0));
 %>
<html>
<head>
<title>ユーザーステータス画面</title>
</head>
<body>
<h1><%=status.get(1) %>さんの部屋：</h1>
    <div class = "status">
    
    			<h3>Id：<%=status.get(0) %></h3>
		        <h3>アカウント名：<%=status.get(1) %></h3>
		        <h3>パスワード：<%=status.get(2) %></h3>
	
				<table border="1">
					<tr>
						<th>クイズを解いた回数</th>
						<th>正解数</th>
						<th>回答時間</th>
					</tr>
					
					<tr>
					<!--  for文で繰り返して出力 -->
						<th>javaコード</th>
						<th><%=status.get(3) %></th>
						<th><%=status.get(4) %></th>
					</tr>
				</table>
    </div>
<a  href="SelectQuiz.jsp">クイズの選択へ進む</a>
</body>
</html>