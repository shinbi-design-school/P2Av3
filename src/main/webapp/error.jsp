<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>エラー</title>
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
	            font-size: 1ex;
	        }
	        
	        #error {
	        	color: red;
	        	font-family: bold;
	        }
	
	        .divError {
	            margin: 0 auto;
	            width: 70%;
	            height: auto;
	            background-color: white;
	            text-align: left;
	            border-radius: 10px;
	        }
	        
	        footer {
	        	text-align: center;
	        }
	

    	</style>
	</head>
	<body>
		<div class="divError">
			<header>
				<h1 id="title">エラー画面</h1>
			</header>
			<main>
				<%
				 String errorMessage = (String)session.getAttribute("errorMessage");
				%>
				<div id="error">
					<%=errorMessage %>
				</div>
			</main>
			<footer>
				<jsp:include page="footer.jsp"/>
			</footer>
		</div>
	</body>
</html>