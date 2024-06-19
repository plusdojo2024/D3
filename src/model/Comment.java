package model;

import java.io.Serializable;

public class Comment implements Serializable {
	private int commentNumber;	//コメント番号
	private String commentValue;	//コメント

	public Comment() {

	}
	public Comment(int commentNumber, String commentValue) {
		super();
		this.commentNumber = commentNumber;
		this.commentValue = commentValue;
	}

	// getter setter
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public String getCommentValue() {
		return commentValue;
	}
	public void setCommentValue(String commentValue) {
		this.commentValue = commentValue;
	}

}
