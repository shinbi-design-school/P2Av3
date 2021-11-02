package cc.shinbi.P2Av3.model;

import cc.shinbi.P2Av3.model.entity.Message;
import cc.shinbi.P2Av3.model.entity.User;

public class Pair {
	private User user;
	private Message message;

	public Pair(User user, Message message) {
		this.user = user;
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public Message getMessage() {
		return message;
	}
}
