package model;
import java.io.Serializable;

public class ResultMessage implements Serializable {

	private String message;		// メッセージ表示


	public ResultMessage() {
		this(null);
	}

	public ResultMessage( String message) {

		this.message = message;

	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
