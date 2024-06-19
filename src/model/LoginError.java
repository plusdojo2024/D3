package model;
import java.io.Serializable;

public class LoginError implements Serializable {
	private String message;		// メッセージ

	public LoginError() {
		this(null);
	}

	public LoginError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
