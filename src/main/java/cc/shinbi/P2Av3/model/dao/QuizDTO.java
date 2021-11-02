package cc.shinbi.P2Av3.model.dao;

public class QuizDTO {

	private int id;
	private String question;
    private String Answer;
    private String subject01;
    private String subject02;
    private String subject03;
//    private String subject04;
//    private String others;

    
    
    
  	public QuizDTO() {
  		// 初期化処理
  		id  = 0;
  		Answer = null;
  		subject01 = null;
  		subject02 = null;
  		subject03 = null;
 // 		subject04 = null;
 // 		others = null;
  	}
 
		// TODO 自動生成されたコンストラクター・スタブ
	public QuizDTO(int id, String question, String Answer, String subject01, String subject02, String subject03) {
	super();
	this.id = id;
	this.question = question;
	this.Answer = Answer;
	this.subject01 = subject01;
	this.subject02 = subject02;
	this.subject03 = subject03;
	}
	
	public QuizDTO(String question, String Answer, String subject01, String subject02, String subject03) {
	super();
	this.question = question;
	this.Answer = Answer;
	this.subject01 = subject01;
	this.subject02 = subject02;
	this.subject03 = subject03;
}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getSubject01() {
		return subject01;
	}
	public void setSubject01(String subject01) {
		this.subject01 = subject01;
	}
	public String getSubject02() {
		return subject02;
	}
	public void setSubject02(String subject02) {
		this.subject02 = subject02;
	}
	public String getSubject03() {
		return subject03;
	}
	public void setSubject03(String subject03) {
		this.subject03 = subject03;
	}
//	public String getSubject04() {
//		return subject04;
//	}
//	public void setSubject04(String subject04) {
//		this.subject04 = subject04;
//	}
//	public String getOthers() {
//		return others;
//	}
//	public void setOthers(String others) {
//		this.others = others;
//	}


	}


	
    
    
    
