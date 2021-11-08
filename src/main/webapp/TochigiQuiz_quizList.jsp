<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="quizSystem.dto.TochigiQuiz_DataTransferObject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Collections" %>
<%
/*
servletによってrequestの中のsessionの情報にworldListの情報が入っている。
そのため、ここで同様に
左辺： List化されたworldDTOクラスのworldList 左辺：session情報（worldListがservletによってsetAttributeされたworldListを取り出す（getAttribute)型が同じなのでキャストしている。
*/
@SuppressWarnings("unchecked")
List<TochigiQuiz_DataTransferObject> list = (List<TochigiQuiz_DataTransferObject>)session.getAttribute("quizList");//sessionよりサーブレットでsetAttributeしたものを取り出す。
System.out.println(list);
Collections.shuffle(list);//listの中身をシャッフルする。

String quizName = (String)session.getAttribute("quizName");
System.out.println(quizName);
%>

<html>
<head>
<meta charset="utf-8">
<title>クイズ</title>
</head>
<body>
<h3>
<%=quizName %>
</h3>

<form method="post" action="http://localhost:8080/P2Av3/TochigiQuiz_ResultServlet">
    <div class = "selection">
    <input name="quizName" value=<%=quizName %> type="hidden">
		<%
		for(int i=0; i<list.size();i++){//質問文を複数出したいためfor文使用
		%>
        <h3>質問文<%=i+1 %>：<%=list.get(i).getQuestion() %>
        	 <input id="question" name="question<%=i %>" value="<%=list.get(i).getQuestion() %>" type="hidden" >
        <!--	 <input id="questionNumberOfTime" name = "numberOfTime" value=  type="hidden">  -->
        </h3>
        <!--＜％％＞でとってきた質問文に付随する選択肢を下記で表示-->
        <span>
        <input id="selection_radio1" name="selectionCheck<%=i %>" value="1" type="radio" checked>
        <input name="selection<%=i %>" value="選択肢１：<%=list.get(i).getSelection1() %>" type="hidden">
        <label for="radio">選択肢１:<%=list.get(i).getSelection1() %></label>
        <p></p>
        </span>
        <span>
        <input id="selection_radio2" name="selectionCheck<%=i %>" value="2" type="radio">
        <input name="selection<%=i %>" value="選択肢２：<%=list.get(i).getSelection2() %>" type="hidden">
        <label for="radio">選択肢2:<%=list.get(i).getSelection2() %></label>
        </span>
        <p></p>
        <span>
        <input id="selection_radio3" name="selectionCheck<%=i %>" value="3" type="radio" >
        <input name="selection<%=i %>" value="選択肢３：<%=list.get(i).getSelection3() %>" type="hidden">
        <label for="radio">選択肢３:<%=list.get(i).getSelection3() %></label>
        </span>
        <p></p>
        <span>
        <input id="selection_radio4" name="selectionCheck<%=i %>" value="4" type="radio">
        <input name="selection<%=i %>" value="選択肢４：<%=list.get(i).getSelection4() %>" type="hidden">
        <label for="radio">選択肢４:<%=list.get(i).getSelection4() %></label>
        </span>
        <p></p>
        <%
		}
        %>
        <%long startTime = System.currentTimeMillis(); %>
    </div>
    <div>
    	 <input type="hidden" name="numberOfTimes" value=<%=list.size() %> >
    	 <input type="hidden" name="List" value=<%=list %>>
    	 <input type="hidden" name="startTime" value=<%=startTime%>>
    	 <input type="reset" value="やり直し">
    	  <!-- <input type="submit" name="method" value="答えを送信する"> -->
    	 <button type="submit" name="endTime" value="endTime">答えを送信する</button>
    </div>
</form>

</body>
</html>