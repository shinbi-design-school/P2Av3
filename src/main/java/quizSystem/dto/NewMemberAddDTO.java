package quizSystem.dto;

public class NewMemberAddDTO {
	private int id;
	private String accountname;
	private String password;
	private byte[] passwordBytes;
	
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
	public void setPasswordBytes(byte[] passwordByte) {
		this.passwordBytes = passwordByte;
	}

	
	

}
