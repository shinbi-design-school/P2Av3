<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>クイズ選択</title>
</head>
<body>
	<header>
		<h3>何のクイズを行うか以下から選択してね。</h3>
	</header>
	<main>
		<form method="post" action="TochigiQuiz_QuizShowServlet">
		    <div class = "selection">
		        <h3>
			        <input id="selection_quiz1" name="quizName" value="栃木クイズ" type="radio" checked>
			        <label for="radio">栃木クイズ</label>
		        </h3>
				<h3>
					<input id="selection_quiz2" name="quizName" value="●●クイズ" type="radio" checked>
			        <label for="radio">●●クイズ</label>
		        </h3>
		        <h3>
					<input id="selection_quiz3" name="quizName" value="●●クイズ" type="radio" checked>
			        <label for="radio">●●クイズ</label>
		        </h3>
		        <h3>
					<input id="selection_quiz4" name="quizName" value="●●クイズ" type="radio" checked>
			        <label for="radio">●●クイズ</label>
		        </h3>
		    </div>
		     <button type="submit" name="" value="選択を送信する。">チェックしたクイズを行う。</button>
		</form>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>

</body>
</html>