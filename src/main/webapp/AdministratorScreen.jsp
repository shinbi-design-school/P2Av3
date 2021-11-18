<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel = "stylesheet" type="text/css" href="css/AdministratorScreen.css">
	<title>管理者画面</title>
    <style>
        header {
            margin: 0 auto;
            padding: 10px;
            text-align: center;
            font-size: 5ex;
        }

        body {
            background-color: orange;
            user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
            -moz-user-select: none;
            -khtml-user-select: none;
            -webkit-user-drag: none;
            -khtml-user-drag: none;
        }

        #title {
            text-align: center;
            padding-top: 50px;
            padding-bottom: 0px;
            font-size: 4ex;
        }

        #problem {
            height: 40px;
            margin-left: 40px;
        }

        .sample1 {
            margin: 0 auto;
            width: 70%;
            height: auto;
            background-color: white;
            text-align: left;
            border-radius: 10px;
        }

        .sample2 {
            margin-top: 0px;
            margin-bottom: 0px;
            margin-left: 80px;

        }

        footer {
            text-align: center;
        }

    </style>
</head>
<body>
	<div class="sample1">
		<header>
			<h1>管理者画面</h1>
		</header>
		<main class="sample2">
				<h3 id="member">1,<a href="MembersServlet">現在ログインできる登録したメンバーを確認する。</a></h3>
				<h3 id="login">2,<a href="login.jsp">ログインする</a></h3>
				<h3 id="memberAdd">3,<a href="NewMemberAdd.jsp">メンバー登録する</a></h3>
				<h3 id="delete">4,<a href="memberDelete.jsp">メンバーを削除する</a></h3>
				<h3 id="query">5,<a href="inqueryFormAllShow.jsp">お客さんからの問い合わせ依頼を見る。</a></h3>
		</main>
		<footer>
			<jsp:include page="footer.jsp"/>
		</footer>
	</div>
</body>
</html>