package cc.shinbi.P2Av3.model.entity;

public class Message extends EntityBase {
	private int userId;
	private String text;
	private String imageFileName;
	private boolean publicMessage;

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public boolean isPublicMessage() {
		return publicMessage;
	}
	public void setPublicMessage(boolean publicMessage) {
		this.publicMessage = publicMessage;
	}
}
