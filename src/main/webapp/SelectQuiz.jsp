<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>クイズ選択</title>
	 <style>
        button:hover img {
            opacity: 0.6;
            filter: alpha(opacity=60);
            display: block;
            width: 50px;
            height: 50px;
        }

        header {
            margin: 0 auto;
            padding: 10px;
            padding-left: 100px;
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

        form {
            display: block;
            text-align: center;
            margin: auto;
            height: 180px;
            width: auto;
        }

        .selection {}

        .button {
            box-sizing: content-box;
            width: 90%%;
            padding-top: 10px;
            padding-bottom: 10px;
            padding-left: 100px;
            padding-right: 100px;
            margin-left: 50px;
            font-size: 25px;
            text-decoration: none;
            position: relative;
            background-color: #1abc9c;
            border-radius: 15px;
            color: white;
            line-height: 120px;
            -webkit-transition: none;
            transition: none;
            box-shadow: 0 3px 0 #0e8c73;
            text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
        }

        .button:hover {
            background-color: #31c8aa;
            box-shadow: 0 3px 0 #23a188;
        }

        .button:active {
            top: 3px;
            box-shadow: none;
        }

        .box1{
        	margin-left: auto;
        	margin-right: auto;
            float: left;
            width: 50%;
            
            text-align: right;
        }
        
        .box2{
        	margin-left: auto;
        	margin-right: auto;
            float: left;
            width: 50%;
            
            text-align: left;
        }
        
        .box3{
        	margin-left: auto;
        	margin-right: auto;
            float: left;
            width: 50%;
            
            text-align: right;
        }
        
        .box4{
        	margin-left: auto;
        	margin-right: auto;
            float: left;
            width: 50%;
            
            text-align: left;
        }
        
        footer {
        	margin-left: auto;
        	margin-right: auto;
        	text-align: center;
        	font-size: 25px;
        }
        
    </style>
</head>
<body>
    <script>
        onMouseDown = "return false;"
        onSelectStart = "return false" <
            body onMouseDown = "return false;"
        onSelectStart = "return false" >
    </script>
    <%
    	String id = (String)session.getAttribute("id");
    	String accountName = (String)session.getAttribute("accountName");
    	if(accountName != null && id != null){
    		accountName = (String)session.getAttribute("accountName");
    		id = (String)session.getAttribute("id");
    	}
    	else{
    		accountName = "ゲスト";
    		id = null;
    	}
    	
    	
    
    %>
	<header>
		<h3><%=accountName %>さんようこそ！</h3>
		<h3>何のクイズを行うか以下から選択してね。</h3>
	</header>
	<main>
		<form method="post" action="TochigiQuiz_QuizShowServlet"  class="box1" >
			<button type="submit" name="quizName" value="栃木クイズ" class="button" >栃木クイズ　</button>
			<input type="hidden" name="accountName" value=<%=accountName%>>
			<input type="hidden" name="id" value=<%=id %>>
		</form>
		<form method="post" action="TochigiQuiz_QuizShowServlet"  class="box2">
			<button type="submit" name="quizName" value="雑学クイズ２" class="button" >雑学クイズ２</button>
			<input type="hidden" name="accountName" value=<%=accountName%>>
			<input type="hidden" name="id" value=<%=id %>>       
		</form>
		<form method="post" action="TochigiQuiz_QuizShowServlet" class="box3" >
			<button type="submit" name="quizName" value="雑学クイズ３" class="button" >雑学クイズ３</button>
			<input type="hidden" name="accountName" value="<%=accountName%>">
			<input type="hidden" name="id" value=<%=id %>>
		</form>
		<form method="post" action="TochigiQuiz_QuizShowServlet" class="box4" >
			 <button type="submit" name="quizName" value="未実装クイズ" class="button" >未実装クイズ４</button>
			 <input type="hidden" name="accountName" value=<%=accountName%>>
			 <input type="hidden" name="id" value=<%=id %>>
		</form>
	</main>
	<footer>
		<jsp:include page="footer.jsp"/>
	</footer>

</body>
</html>