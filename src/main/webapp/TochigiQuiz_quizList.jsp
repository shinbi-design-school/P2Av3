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
String accountName = (String)session.getAttribute("accountName");
String id = (String)session.getAttribute("id");
%>

<html>
<head>
	<meta charset="utf-8">
	<title>クイズ</title>
	<!-- 
	<link rel="stylesheet"  type="text/css" href="css/quizList.css">
	-->
	  <style>	  
	  	body {
            background-color: orange;
        }
	  
        header {
            margin: 0 auto;
            padding: 10px;
            text-align: center;
            font-size: 5ex;
        }
        
        /*クイズの名前のcss*/
        #title {
            text-align: center;
            padding-top: 50px;
            padding-bottom: 0px;
            font-size: 4ex;
        }
    
        form {
            margin: 0 auto;
            width: 70%;
            height: auto;
            background-color: white;
            text-align: center;
            border-radius: 10px;
        }
        
        /*質問文のcss*/
        #Question {
            height: 40px;
            margin-left: 40px;
        }
        
        /*radioボタンの編集*/
   
        input[type="radio"] {
         display: ;/*標準ラジオボタンを非表示*/
         width: 20px;
         height: 20px;
        }
       
        /*labelの編集*/
        
        label {
        	cursor: pointer;
            display: block;
            width: 40%;
            padding: 10px;
            margin-left: auto;
            margin-right: auto;
            text-align: center;
            text-decoration: none;
            color: #33CCFF;
            border: 2px solid #33CCFF;
            border-radius: 30px;
            transition: ;
        }
       
        
        
        /*送信ボタンのcss*/
       
        #Button {
        	 text-align: right;
        }
        
        button {
            box-sizing: content-box;
            width: 100px;
            height: 36px;
            margin: 0,0,auto,0;
            padding-top: 10px;
            padding-bottom: 10px;
            padding-left: 3%;
            padding-right: 3%;
            text-decoration: none;
            position: relative;
            background-color: white;
            border-radius: 10px;
            color: black;
            line-height: 120px;
            -webkit-transition: none;
            transition: none;
            box-shadow: 0 3px 0 #0e8c73;
            text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
        }

        button:hover {
            background-color: #31c8aa;
            box-shadow: 0 3px 0 #23a188;
        }

        button:active {
            top: 3px;
            box-shadow: none;
        }
       
       #reset {
       	    box-sizing: content-box;
            width: 100px;
            height: 36px;
            margin: 0,0,auto,0;
            padding-top: 10px;
            padding-bottom: 10px;
            padding-left: 3%;
            padding-right: 3%;
            text-decoration: none;
            position: relative;
            background-color: white;
            border-radius: 10px;
            color: black;
            line-height: 120px;
            -webkit-transition: none;
            transition: none;
            box-shadow: 0 3px 0 #0e8c73;
            text-shadow: 0 1px 1px rgba(0, 0, 0, .3);
       }
       
        #reset:hover {
            background-color: #31c8aa;
            box-shadow: 0 3px 0 #23a188;
        }

        #reset:active {
            top: 3px;
            box-shadow: none;
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

	<header>
		<h3 id="title"><%=quizName %></h3>
	</header>
	<form  method="post" action="TochigiQuiz_ResultServlet">
	    <div class = "">
	    <input name="quizName" value=<%=quizName %> type="hidden">
			<%
			for(int i=0; i<list.size();i++){//質問文を複数出したいためfor文使用
			%>
	        <h3 id="Question">質問文<%=i+1 %>：<%=list.get(i).getQuestion() %>
	        	 <input id="question" name="question<%=i %>" value="<%=list.get(i).getQuestion() %>" type="hidden" >
	        <!--	 <input id="questionNumberOfTime" name = "numberOfTime" value=  type="hidden">  -->
	        </h3>
	        <!--＜％％＞でとってきた質問文に付随する選択肢を下記で表示-->
	        <label>
		        <input id="radioButton" class="button" name="selectionCheck<%=i %>" value="1" type="radio"  checked>
		        <input name="selection<%=i %>" value="選択肢1：<%=list.get(i).getSelection1() %>" type="hidden">
		       	選択肢１:<%=list.get(i).getSelection1() %>
	       	</label>
	        
	        <p></p>
			<label>
				<input name="selectionCheck<%=i %>" value="2" type="radio">
		        <input name="selection<%=i %>" value="選択肢２：<%=list.get(i).getSelection2() %>" type="hidden">
		    	選択肢２:<%=list.get(i).getSelection2() %>
	    	</label>

	        <p></p>

	        <label>
	        	<input name="selectionCheck<%=i %>" value="3" type="radio" >
		        <input name="selection<%=i %>" value="選択肢３：<%=list.get(i).getSelection3() %>" type="hidden">
				選択肢３:<%=list.get(i).getSelection3() %>
			</label>

	        <p></p>
			<label >
				<input name="selectionCheck<%=i %>" value="4" type="radio">
		        <input name="selection<%=i %>" value="選択肢４：<%=list.get(i).getSelection4() %>" type="hidden">
		      	選択肢４:<%=list.get(i).getSelection4() %>
	      	</label>

	        <p></p>
	        <%
			}
	        %>
	        <%long startTime = System.currentTimeMillis(); %>
	    </div>
	    <div class="Button">
	    	 <input type="hidden" name="numberOfTimes" value=<%=list.size() %> >
	    	 <input type="hidden" name="List" value=<%=list %>>
	    	 <input type="hidden" name="startTime" value=<%=startTime%>>
	    	 <input type="hidden" name="accountName" value=<%=accountName %>>
	    	 <input type="hidden" name="id" value=<%=id %>>
	    	 <input type="hidden" name="quizName" value=<%=quizName %>> 
	    	 
	    	 
	    	 <button id="reset" type="reset"  name="reset" value="やり直し">やり直し</button>
	    	 <button type="submit" name="endTime" value="endTime">答えを送信する</button>
	    </div>
	</form>

</body>
</html>