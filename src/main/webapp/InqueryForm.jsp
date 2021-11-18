<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE htmlL>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー情報問い合わせ入力フォーム</title>
</head>
<body>
<h1>問い合わせ入力</h1>
<h4>※下記で入力して頂くメールアドレス宛に返答させて頂きます。
	メールアドレスは間違いないよう入力をお願いいたします。</h4>
<form method="post" action="InqueryFormServlet">
     <table>
        <tr>
          <th><label for="name_form">アカウント名</label></th>
          <td><input id="accountname" name="accountname" type="text" required></td>
        </tr>
        <tr>
          <th><label for="mail_form">メールアドレス</label></th>
          <td><input id="email" name="email" type="email" required></td>
        <tr>
         <th>
          <label for="remarks_text">問い合わせ内容</label>
         </th>
          <td><textarea id="remarks_text" name="inquery" rows="8" ></textarea></td>
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
		  <input type="hidden" name="hidden_parameter" value="隠しパラメーター">
		</form>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>
</body>
</html>