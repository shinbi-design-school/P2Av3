<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quizSystem.dto.LoginDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="quizSystem.dao.RegistrationOfResultsDAO" %>

<%
	String[] user = (String[])session.getAttribute("user");
	int userid = Integer.parseInt(user[0]);
	
System.out.println("user[]の情報が格納されているか確認");
System.out.println(user[0]);
System.out.println(user[1]);
System.out.println(user[2]);
	//DAO
	RegistrationOfResultsDAO add = new RegistrationOfResultsDAO();
	
	//情報の格納
	List<String> correctNumberList = add.selectCorrect(userid);
	List<String> answerTimeList = add.selectTime(userid);

System.out.println(correctNumberList);
System.out.println(answerTimeList);

 %>
<html>
<head>
	<title>ユーザーステータス画面</title>
	<style>
		h5 {
			margin-bottom: 0px;
		}
		h6 {
			margin-top: 0px;
    		margin-bottom: 0px;
		}
		
	
	</style>
</head>
<body>
<h1><%=user[1]/*status.get(1)*/ %>さんの部屋：</h1>
    <div class = "status">
    
    			<h3>Id：<%=user[0]/*status.get(0)*/%></h3>
		        <h3>アカウント名：<%=user[1]/*status.get(1)*/ %></h3>
		        <h3>ハッシュ化パスワード：<%=user[2]/*status.get(2)*/ %></h3>
	
				<table border="1">
					<tr>
						<th>日時</th>
						<th>解いたクイズ名</th>
						<th>正解数</th>
						<th>回答時間（秒）</th>
					</tr>
					
					<%
					/*
					int userid = (Integer)session.getAttribute("id");
					String accountName = (String)session.getAttribute("accountName");
					List<Integer> correctNumberList = (List<Integer>)session.getAttribute("correctNumberList");
					List<Integer> answerTimeList = (List<Integer>)session.getAttribute("answerTimeList");
					*/
					for(int i=0; i< correctNumberList.size(); i++){
					%>
					<tr>
						<th><%=answerTimeList.get(3*i+1) %></th>
						<th><%=answerTimeList.get(3*i+2) %></th>
						<th><%=correctNumberList.get(i) %></th>
						<th><%=answerTimeList.get(3*i) %>（秒）</th>
		
					</tr>
					<%
					}
					%>
				</table>
    </div>

<p></p>   
    
<form id="userStatus" method="post" action="AccountNameToSelectQuizServlet">
	<input type="hidden" value=<%=user[0] %> name="id">
	<input type="hidden" value=<%=user[1] %> name="accountName">
	<input type="hidden" value=<%=user[2] %> name="passwordBytesString">
	<button type="submit" name="" value="">クイズへ進む</button>
</form>

<p></p>

<form id="userStatus" method="post" action="PasswordChangeServlet">
	<h5>パスワードを変更する</h5>
	<h6>※下記の入力欄に変更したいパスワードを入力して「パスワードを変更する。」のボタンを押してください。</h6>
	<input type="password" name="passwordChange" maxlength="10"/>
	<input type="hidden" value=<%=user[0] %> name="id">
	<input type="hidden" value=<%=user[1] %> name="accountName">
	<input type="hidden" value=<%=user[2] %> name="passwordBytesString">
	<p></p>
	<input id="submit" type="submit" value="パスワードを変更する。">
</form>

<p></p>
	<a href="InqueryForm.jsp"><input type="submit" value="不明点の問い合わせフォーム"></a>
<p></p>
<form method ="post" action="ReplyUserShowServlet" >
	<input id = "reply"type="hidden" value=<%=user[0] %> name = "userid">
	<input type="submit" value="問い合わせの返答を確認する。" name="送信">
</form>

</body>
</html>