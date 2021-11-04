package quizSystem.dto;

import java.io.Serializable;//javaBeans?

//field,getter,setterのみ
public class TochigiQuiz_DataTransferObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//
	private int answer;
	private String question;
	private String selection1;
	private String selection2;
	private String selection3;
	private String selection4;
	
	//コンストラクタ
	public TochigiQuiz_DataTransferObject() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSelection1() {
		return selection1;
	}

	public void setSelection1(String selection1) {
		this.selection1 = selection1;
	}

	public String getSelection2() {
		return selection2;
	}

	public void setSelection2(String selection2) {
		this.selection2 = selection2;
	}

	public String getSelection3() {
		return selection3;
	}

	public void setSelection3(String selection3) {
		this.selection3 = selection3;
	}

	public String getSelection4() {
		return selection4;
	}

	public void setSelection4(String selection4) {
		this.selection4 = selection4;
	}

	
}