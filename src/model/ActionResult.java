package model;
import java.io.Serializable;

public class ActionResult implements Serializable {

	private String message;		// メッセージ表示


	public ActionResult() {
		this(null);
	}

	public ActionResult( String message) {

		this.message = message;

	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
