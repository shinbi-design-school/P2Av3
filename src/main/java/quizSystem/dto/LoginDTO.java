package quizSystem.dto;

import java.io.Serializable;//javaBeans?
import java.sql.Time;

//field,getter,setterのみ
public class LoginDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//
	private String accountname;
	private String password;
	
	private int userId;
	private Time answerTime;
	private int correctNumber;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Time getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Time answerTime) {
		this.answerTime = answerTime;
	}
	public int getCorrectNumber() {
		return correctNumber;
	}
	public void setCorrectNumber(int correctNumber) {
		this.correctNumber = correctNumber;
	}


}