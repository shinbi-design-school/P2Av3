package quizSystem.dto;

import java.sql.Time;

public class RegistrationOfResultsDTO {
	private int userId;
	private String accountName;
	private Time answerTime;
	private String correctNumber;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Time getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Time answerTime) {
		this.answerTime = answerTime;
	}
	public String getCorrectNumber() {
		return correctNumber;
	}
	public void setCorrectNumber(String correctNumber) {
		this.correctNumber = correctNumber;
	}
	
	
	

}
