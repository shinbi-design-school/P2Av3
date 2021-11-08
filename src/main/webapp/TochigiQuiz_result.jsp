<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="quizSystem.dto.TochigiQuiz_DataTransferObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<html>
<head>
<meta charset="utf-8">
<title>クイズ</title>
</head>
<body>
<form method="post" action="">
<%String quizName = (String)session.getAttribute("quizName"); %>
<h3><%=quizName %></h3>
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
		        <h3>質問文<%=i+1 %>：<%=viewquestion %></h3>
			        <h5><label>・<%=selection1 %></label></h5>
			        <h5><label>・<%=selection2 %></label></h5>
			        <h5><label>・<%=selection3 %></label></h5>
			        <h5><label>・<%=selection4 %></label></h5>
			        <h5><label>あなたが選んだ選択肢:<%=selectanswerString %></label></h5>
			        <h5><label>答え:<%=trueanswerString%></label></h5>
			        <h5><label><%=correct %></label></h5>

		<%
		 }
		%>
    </div>
    	<h5>正解数＝<%=correctCount%>/<%=((list.size()-1)/8) %></h5>
    	<h5>回答時間（秒）＝<%=list.get(list.size()-1) %>（秒）</h5>
</form>
</body>
</html>