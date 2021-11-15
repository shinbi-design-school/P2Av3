package quizSystem.dto;

public class PasswordChangeDTO {
	int id;
	String accountname;
	String password;
	String psswordByteString;
	
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
	public String getPsswordByteString() {
		return psswordByteString;
	}
	public void setPsswordByteString(String psswordByteString) {
		this.psswordByteString = psswordByteString;
	}
	
}
