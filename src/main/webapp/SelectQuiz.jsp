<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<title>クイズ選択</title>
</head>
<body>
<h3>なんのクイズを行うか以下から選択してね。</h3>

<form method="post" action="●●">
    <div class = "selection">
        <h3><a href="http://localhost:8080/P2Av3/TochigiQuiz_QuizShowServlet">栃木クイズ
        	<input id="栃木クイズ" name="栃木クイズ" value="1" type="hidden"  >
			</a>
        </h3>
		<h3><a href="">●●クイズ
        	<input id="●●クイズ" name="●●クイズ" value="●●クイズ" type="hidden" >
			</a>
        </h3>
        <h3><a href="">●●クイズ
        	<input id="●●クイズ" name="●●クイズ" value="●●クイズ" type="hidden" >
			</a>
        </h3>
        <h3><a href="">●●クイズ
        	<input id="●●クイズ" name="●●クイズ" value="●●クイズ" type="hidden" >
			</a>
        </h3>
    </div>
</form>

</body>
</html>