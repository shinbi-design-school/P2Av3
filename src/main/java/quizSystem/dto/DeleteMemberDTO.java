package quizSystem.dto;

public class DeleteMemberDTO {
	int id;
	String accountname;
	String password;
	byte[] passwordBytes;
	

	public DeleteMemberDTO() {
		id = 0;
		accountname = null;
		password = null;
	}

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
	
	public byte[] getPasswordBytes() {
		return passwordBytes;
	}

	public void setPasswordBytes(byte[] passwordBytes) {
		this.passwordBytes = passwordBytes;
	}

	

}
