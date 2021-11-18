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
	<style>
        header {
            margin-right: auto;
            margin-left: auto;
            padding: 10px;
            text-align: center;
            font-size: 5ex;
        }

        body {
            background-color: orange;
            margin-left: 0;
        }

        #title {
            text-align: center;
            padding-top: 50px;
            padding-bottom: 0px;
            font-size: 2ex;
        }

        .sample1 {
            margin: 0 auto;
            width: 60%;
            height: auto;
            background-color: white;
            text-align: left;
            border-radius: 10px;
        }

        .sample2 {
        	text-align: center;

        }
        
        #login {
        	display: block;
        	text-align: center;
        }

        a {
            text-align: right;
            margin-right: 30px;
        }
        
        footer {
        	text-align: center;
        }
     </style>
</head>
<body>
<body>
	<header>
		<h1 id="title">全ユーザーリスト</h1>
	</header>
	<h3>メンバーを削除したので全ユーザーリストに削除したメンバーが入っていないか、
	「ctrl + F　で　id,accountname,passwordが含まれていないか確認してください。」</h3>

	<main>
			<form class="sample1" method="post" action="">
				<div class="sample2">
					<table border="1" id="deleteMemberAfterUsers">
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
					</table>
					<a href="AdministratorScreen.jsp">管理者画面に戻る</a>
				</div>
			</form>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
</html>