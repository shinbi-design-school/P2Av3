<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="quizSystem.dto.TochigiQuiz_DataTransferObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Timestamp" %>

<html>
<head>
	<meta charset="utf-8">
	<title>クイズ</title>
	<style>
	    header {
            margin: 0 auto;
            padding: 10px;
            text-align: center;
            font-size: 5ex;
        }

        body {
            background-color: orange;
        }

        #title {
            text-align: center;
            padding-top: 50px;
            padding-bottom: 0px;
            font-size: 4ex;
        }

        #Question {
        	position: ;
            height: 40px;
            margin-left: 40px;
            margin-top: 5px;
            margin-bottom: 5px;
        }

        .button {
            box-sizing: content-box;
            width: 100%;
            height: 36px;
            margin: 10px 20px 30px 0px;
            padding-top: 10px;
            padding-bottom: 10px;
            padding-left: 3%;
            padding-right: 3%;
            text-decoration: none;
            position: relative;
            background-color: #1abc9c;
            border-radius: 10px;
            color: red;
            line-height: 120px;
            -webkit-transition: none;
            transition: none;
            box-shadow: 0 3px 0 #0e8c73;
            text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
        }

        .button:hover {
            background-color: yellow;
            box-shadow: 0 3px 0 #23a188;
        }

        .button:active {
            top: 3px;
            box-shadow: none;
        }

        .screen {
            margin: 0 auto;
            width: 70%;
            height: auto;
            background-color: white;
            text-align: left;
            border-radius: 10px;
        }

        .selection {
            margin-top: 0px;
            margin-bottom: 0px;
            margin-left: 80px;
        }


        .line {
        	position: absolute;
        	top: 30px;
        	position: static;
            outline: 1px solid orange;
            height: 10px;
        }
        
        .resultBox {
            width: 100%;
            height: 105px;
            margin-top: 0px;
            margin-bottom: 0px;
            margin-left: 50px;
        }
        
         .Box {
        	position: absolute;
        	bottom: 30px
        	position-bottom: 30px;
            border: solid #33CCFF;
            text-align: center;
            height: 80px;
            width: 300px;
            margin-left: 0px;
            margin-right: 0px;
        }
        
        .Box h5 {
        	margin-top: 5px;
        	margin-bottom: 5px;
        }
        
        .line2 {
        	position: absolute;
        	top: 30px;
        	position: static;
            outline: 1px solid orange;
            height: 10px;
        }
        
        .resultAll {
        	margin: auto; 
            border: solid red;
            text-align: center;
            width: 215px;
            height: 100px;
        }
        
        
        .btn {
        	display: block;
        	float: left;
            text-align: right;
            margin: 0,0,auto,0;
        }
        
        #btn-label {
        	display: block;
        	position: absolute;
        	margin-top:25px;
        }
       /*
        .button {
        	position: absolute;
            display: block;
            width: 400px;
            margin-left: -100px;
            padding: 10px;
            text-align: center;
            text-decoration: none;
            color: black;
            background:	#33CCFF;
            border: 2px solid #33CCFF;
            border-radius: 30px;
            transition: ;
        }

        .button:hover {
            background: yellow;
            color: red;
        }

        .button:checked {
            background: #33CCFF;
            color: #fff;
        }
       */
        .ptag {
        	display: flex;
        	margin-bottom: 100px;
        	
        
        }

	
	</style>
</head>
<body>
	<div class="screen">
	<%
	String quizName = (String)session.getAttribute("quizName");
	String accountName = (String)session.getAttribute("accountName");
	String id = (String)session.getAttribute("id");	
	
    long millis = System.currentTimeMillis();
    Timestamp timestamp = new Timestamp(millis);
	
	%>
	<header>
		<h3 id="title"><%=quizName %></h3>

	</header>
	<main>
		
	    <div class = "result">
			<%
			 @SuppressWarnings("unchecked")
			 List<String> list = (List<String>)session.getAttribute("resultList");
			 int correctCount = 0;
			 String correctAnswer = "正解です。";
			 //System.out.println(list);
			 for(int i=0; i<((list.size()-1)/8);i++){//resultListの中に（１、質問、２、選択支(1,2,3,4)、３、答え、４、正解）が繰り返し入っている。リストの最後に回答時間が格納されている。
				 String viewquestion = list.get(8*i);//質問文　リストの(8*i+0)番目に質問が入っているはず、、、
				 String selection1 = list.get(8*i+1);//選択肢１　
				 String selection2 = list.get(8*i+2);//選択肢２　
				 String selection3 = list.get(8*i+3);//選択肢３　
				 String selection4 = list.get(8*i+4);//選択肢４　
				 String selectanswerString = list.get(8*i+5);//選択した答え　リストの(8*i+5)番目に選択した答えが入っているはず、、、
				 String trueanswerString = list.get(8*i+6);//本当の答え
				 String correct = list.get(8*i+7);
				//回答時間がリストの最後に格納されている。list.size()=81だが、リストが0から始まっているので番号は80そのためlist.get(80)＝回答時間
			        if(correctAnswer.equals(correct)){
			        	correctCount = correctCount+1;
			        }
			        else{}
			 
	
			%>
					<div class="line"></div>
			        <h3 id="Question">質問文<%=i+1 %>：<%=viewquestion %></h3>
			        	<div class="selection">
					        <h5><label>・<%=selection1 %></label></h5>
					        <h5><label>・<%=selection2 %></label></h5>
					        <h5><label>・<%=selection3 %></label></h5>
					        <h5><label>・<%=selection4 %></label></h5>
				        </div>
					    <div class="resultBox">
					    		<div class="Box">
							        <h5><label>あなたが選んだ選択肢:<%=selectanswerString %></label></h5>
							        <h5><label>答え:<%=trueanswerString %></label></h5>
							        <h5><label><%=correct %></label></h5>
						        </div>
					    </div>
					    
			<%
			 }
			%>
	    </div>
	 </main>
	 <footer>
	 	<p class="line2"></p>
	 	<form class="resultAll" method="post" action="RegistrationOfResultsServlet">
	 		<input type="hidden" name="accoutName" value=<%=accountName %>>
	 		<input type="hidden" name="id" value=<%=id %>>
	 		<input type="hidden" name="timestamp" value=<%=timestamp.toString()%>>
	 		<input type="hidden" name="quizName" value=<%=quizName %>>
	 		<div class="resultCorrectTime">
		    	<h5>正解数＝<%=correctCount%>/<%=((list.size()-1)/8) %></h5>
		    		<input type="hidden" name="correctCount" value="<%=correctCount%>/<%=((list.size()-1)/8) %>">
		    	<h5>回答時間（秒）＝<%=list.get(list.size()-1) %>（秒）</h5>
		    		<input type="hidden" name="answerTime" value="<%=list.get(list.size()-1) %>">
	    	</div>
	    	<div class="btn">
	    		<button class="button" type="submit" value="結果の登録">１，登録ユーザー：結果を登録する</button>
	    	</div>
	   </form>
	   		<p class="ptag"></p>

	   		<a href="UserStatus.jsp">２，登録ユーザー：結果を登録せずにユーザー画面へ戻る</a>
	   		<p></p>
			<a href="Top.jsp">３，未登録ユーザー：トップ画面へ戻る</a>
	   
	 </footer>
	</div>
</body>
</html>