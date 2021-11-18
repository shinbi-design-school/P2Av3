<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>ログイン画面</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
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
            font-size: 1ex;
        }

        .sample1 {
            margin: 0 auto;
            width: 30%;
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
	<header>
		<h2 id="title">＜ログイン画面＞</h2>
	</header>
<!-- 入れるならheader.jspをいれる -->
	<main>
			<form class="sample1" method="post" action="LoginServlet">
				<div class="sample2">
					<table id="login">
						<tr>
							<th>アカウント名</th>
							<td><input type="text" name="accountname" maxlength="" /></td>
						</tr>
						<tr>
							<th>パスワード</th>
							<td><input type="password" name="password" maxlength="10"/></td>
					
						</tr>
						<tr>
							<td><input id="submit" type="submit" value="ログイン">
								<a type="submit"  href="NewMemberAdd.jsp">新規登録</a>
							</td>
						</tr>
					</table>
				</div>
			</form>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
	</body>
</html>