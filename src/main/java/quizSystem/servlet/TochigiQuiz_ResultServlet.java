package quizSystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizSystem.dao.TochigiQuiz_DataAccessObject;
import quizSystem.dto.TochigiQuiz_DataTransferObject;

/**
 * Servlet implementation class TestResultServlet2_5
 */
@WebServlet("/TochigiQuiz_ResultServlet")
public class TochigiQuiz_ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TochigiQuiz_ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードなどの設定
				response.setContentType("text/html; charaset=utf-8");
				request.setCharacterEncoding("UTF-8");
				
		//DAO,DTOのインスタンス
				TochigiQuiz_DataAccessObject quizDAO = new TochigiQuiz_DataAccessObject();//DBアクセスのオブジェクトをインスタンス
				List<TochigiQuiz_DataTransferObject> quizList = quizDAO.pullInfromationCountryFromDatabase();//DAOのメソッド実行してDBテーブルの１行目、２行目、、、ｎ行目とリスト取得
				TochigiQuiz_DataTransferObject listDTO;// = (DataTransferObject)quizList.get(i);ここを下記に移動//i=1で指定すればリストの１行目を取ってくるというコードになる。
				
		//DBからの値を格納するリスト群
				List<String> listquestion = new ArrayList<>();//sqlのquestion文を全部格納したいので設定
				List<Integer> listTrueAnswer = new ArrayList<>();//sqlのanswerのリストとして設定
				Map<String,Integer> map = new HashMap<>();////mapでsqlの問題と値を紐づけするために設定
				
		//回答者から送られてきた値を格納するリスト群
				//回答時間
				long endTime = System.currentTimeMillis();
				String startTimeString = request.getParameter("startTime");
				long startTime = Long.parseLong(startTimeString);
				long answerTime = (endTime - startTime)/1000;
//System.out.println("回答時間が取得できているか");
//System.out.println(answerTime);
				
				//何のクイズを行っているか
				String quizName = request.getParameter("quizName");
System.out.println("何のクイズを行っているか");
System.out.println(quizName);
				
				//回答者に質問を何問提示したか
				String numberOfTimesString = request.getParameter("numberOfTimes");//回答者に提示した質問数
				int numberOfTimes = Integer.parseInt(numberOfTimesString);//数値型に変換
				
//System.out.println("コンソール表示１：質問の繰り返し回数");
//System.out.println(numberOfTimes);
				
				//回答者に回答を提示する際の質問リスト
				List<String> listViewQuestion = new ArrayList<>();
				//回答者が見た選択肢を格納したリスト
				List<String> listViewSelection = new ArrayList<>();
				//回答者に回答を提示する選択した答えのリスト
				List<String> listSelectAnswerString = new ArrayList<>();
				List<Integer> listSelectAnswer = new ArrayList<>();
				//回答者に提示する本当の答えのリスト
				List<Integer> listViewTrueAnswer = new ArrayList<>();
				List<String> listViewTrueAnswerString = new ArrayList<>();
				//正解、不正解を格納するリスト
				List<String> listCorrct = new ArrayList<>();//正解・不正解を格納するリストとして作成
				//結果を格納するリスト
				List<String> resultList = new ArrayList<>();
				
		//回答者から送られてきたリクエストパラメーターを取得
				//提示された質問文の順番で質問文をリストに格納
				for(int i=0; i<numberOfTimes; i++) {
					//回答者に提示した質問文のリストを作成する
					//getParameterの"name"を作成するため、Stringどうしの結合を利用
					String parameterName_question = "question";//getParameter("name")でquestion1,question2,,,の値をとりたいので設定
					String numberOfRepetitions = Integer.toString(i);//数字を文字列に変換
					
					StringBuffer buffer = new StringBuffer();//文字列を結合するために設定
					buffer.append(parameterName_question);//question
					buffer.append(numberOfRepetitions);//1,2,3......
					String join = buffer.toString();//question1,question2.....
					String question = request.getParameter(join);//question1,question2...の値をString型で取得
					listViewQuestion.add(question);//リストに格納

//System.out.println("コンソール表示２：listViewQuestion");
//System.out.println(question);
//System.out.println(listViewQuestion);
				}
				//チェックした選択肢をリストに格納
				for(int i=0; i<numberOfTimes;i++) {
					//同上。回答者が回答した選択肢のリストを作成する。
					String parameterName_selectionCheck = "selectionCheck";
					String numberOfRepetitions = Integer.toString(i);//数字を文字列に変換
					
					StringBuffer buffer2 = new StringBuffer();
					buffer2.append(parameterName_selectionCheck);
					buffer2.append(numberOfRepetitions);
					String join2 = buffer2.toString();
					String selectionCheck = request.getParameter(join2);
					listSelectAnswerString.add(selectionCheck);
					int selectAnswer = Integer.parseInt(listSelectAnswerString.get(i));
					listSelectAnswer.add(selectAnswer);
//System.out.println("コンソール表示３：selectAnswer");
//System.out.println(selectAnswer);
//System.out.println(listSelectAnswer);
				}
				
				/*使用しないのでで削除
				Map<List<String>,List<String>> questionSelectAnswerMap = new HashMap<>();
				for(int i=0;i<numberOfTimes;i++) {
					questionSelectAnswerMap.put(listViewQuestion,listSelectAnswerString);
				}
				*/
				
				//提示した選択肢をリストに格納
				for(int i=0; i<numberOfTimes;i++) {
					//同上。回答者に見せた選択肢のリストを作成する。
					String parameterName_selection = "selection";
					String numberOfRepetitions = Integer.toString(i);//数字を文字列に変換
					
					StringBuffer buffer3 = new StringBuffer();
					buffer3.append(parameterName_selection);
					buffer3.append(numberOfRepetitions);
					String join3 = buffer3.toString();
					String[] selection = request.getParameterValues(join3);
					List<String> templist = Arrays.asList(selection);
					listViewSelection.addAll(templist);
//System.out.println("コンソール表示：listViewSelection");
//System.out.println(listViewSelection);
				}
//System.out.println(listViewSelection);
		
		//sqlからデータを取り出しリスト形式で格納
				for(int i=0; i<numberOfTimes;i++) {//本当はi<quizList.size();の方がいいのだが、エラーになるので代替。
					/*sqlのテーブルにある内容を取得*/
						//sqlのテーブルに記載してあるquestion（質問文）をString型配列として格納
						listDTO = (TochigiQuiz_DataTransferObject)quizList.get(i);//カラムのi=1のとき１行目、i=2のとき2行目を示している。list.get(i)はリス(sqlのテーブル）トのi番目をget（id,answer,他）するという意味？
						listquestion.add(listDTO.getQuestion());//右辺：i=1のとき1行目カラムのquestionをgetQuestion()で取り出す　左辺：配列に格納
//System.out.println("コンソール表示４：listquestion");
//System.out.println(listquestion);
						//sqlのテーブルに記載してあるanswer（答え）をString型配列として格納
						listDTO = (TochigiQuiz_DataTransferObject)quizList.get(i);
						listTrueAnswer.add(listDTO.getAnswer());
//System.out.println("コンソール表示５listTrueAnswer");//
//System.out.println(listTrueAnswer);
						//sqlのテーブルに記載してあるquestionとanswerをmapで紐づけ
						map.put(listquestion.get(i),listTrueAnswer.get(i));	//(key,値)
//System.out.println("コンソール表示６：map");
//System.out.println(map);//
				}
		//sqlの質問リストと答えのリストが紐づけされていて、回答者が回答した質問の本当の答えを取り出し格納
				for(int i=0; i<numberOfTimes; i++) {
					/*sqlのテーブルにある質問の中から回答者が回答した質問があるか検索。その後、その質問の答えを抽出。リストに格納*/
					if(map.keySet().contains(listViewQuestion.get(i))) {//mapの中にあるketの中でviewquestionと同じものがsqlのテーブルのquestionの中にあるか検索
						int trueanswer=map.get(listViewQuestion.get(i));//sqlのquestionにviewquestionと同じ質問文があればmapで紐づいている値を取得し、tureanswerに格納
						listViewTrueAnswer.add(trueanswer);
						String trueanswerString = Integer.toString(trueanswer);
						listViewTrueAnswerString.add(trueanswerString);
//System.out.println("コンソール表示７：listViewTrueAnswer");
//System.out.println(listViewTrueAnswer);//ok
//System.out.println(listViewTrueAnswerString);//
					}
				}
				
		//回答者が選択した答えと本当の答えがあっているか判定。判定を格納
				for(int i=0; i<numberOfTimes; i++) {
					String correct;//正解・不正解の文字列格納する変数を用意
						if(listSelectAnswer.get(i) == listViewTrueAnswer.get(i)) {//if文で正解・不正解を確認
							correct = "正解です。";
						}else {
							correct = "不正解です。";
						}
						listCorrct.add(correct);//正解・不正解を格納するリストに入れる。
						//Collections.reverse(listCorrct);
//System.out.println("コンソール表示８：listCorrect");
//System.out.println(listCorrct);
				}
				/*以下に答えのリストを作成する。*/
				/*下記コード
				 * List形式で格納
				 １、質問文
				 ２，答え番号
				 ３，選択支で選んだ番号
				 ４，正解・不正解
				 */
//System.out.println("コンソール表示９：listViewTrueAnswerString");

	//質問文、選択肢、選んだ答え、本当の答え、判定結果を結果のリストに格納
		for(int i=0; i<numberOfTimes; i++) {
				resultList.add(listViewQuestion.get(i));//リストの(i)番目：提示している質問文をlistquestionの中から取り出してadd
			for(int l=4*i; l<4*i+4; l++) {
				resultList.add(listViewSelection.get(l));//i=0回目l=0~3 i=1回目4~7 i=2回目8~11,,,,
			}
				resultList.add(listSelectAnswerString.get(i));//リストの(i)番目：回答者が選択した回答番号をadd
				resultList.add(listViewTrueAnswerString.get(i));//リストの(i)番目：質問の正しい答えをadd
				resultList.add(listCorrct.get(i));//リストの(i)番目：正解・不正解が記述されたものをadd
		}
		String answerTimeString = Long.toString(answerTime);
		resultList.add(answerTimeString);//
//System.out.println("コンソールに表示1０:結果result");
//System.out.println(resultList);
//System.out.println(resultList.size());

	//ブラウザに情報を送信する準備
			HttpSession session = request.getSession();//
			session.setAttribute("resultList",resultList);//
			session.setAttribute("quizName", quizName);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("TochigiQuiz_result.jsp");//
			rd.forward(request,response);
	}
}
