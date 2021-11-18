<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>memberDelete</title>
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
            font-size: 2ex;
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

        .sample3 {
            text-align: right;
            margin-right: 30px;
        }


     </style>
</head>
<body>
	<div class="sample1">
		<header>
				<h1 id="title">メンバー削除画面</h1>
		</header>
		<main>
				<form class="sample1" method="post" action="DeleteMemberServlet">
					<div class="sample2">
						<table id="memberDelete">
							<tr>
								<th>削除するId</th>
								<td><input type="text" name="deleteId" maxlength="" /></td>
							</tr>
						
							<tr>
								<th>削除するアカウント名</th>
								<td><input type="text" name="deleteAccountname" maxlength="" /></td>
							</tr>
							<tr>
								<th>削除するパスワード</th>
								<td><input type="password" name="deletePassword" maxlength=""/></td>
							</tr>
							<tr>
								<td><input id="submit" type="submit" value="入力したメンバーを削除する。"></td>
							</tr>
		
						</table>
					</div>
				</form>
				<div class="sample3">
					<a type="submit" type="submit" href="AdministratorScreen.jsp">管理者の画面に戻る</a>
				</div>
		</main>
		<footer>
			<jsp:include page="footer.jsp"/>
		</footer>
	</div>
	</body>
</html>