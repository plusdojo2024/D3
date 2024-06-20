package model;

import java.io.Serializable;

public class GroupMember implements Serializable {
	private int groupNumber;
	private int number;
	private int orderNumber;
	private int deleteNumber;

	public GroupMember() {

	}
	public GroupMember(int groupNumber, int number, int orderNumber, int deleteNumber) {
		super();
		this.groupNumber = groupNumber;
		this.number = number;
		this.orderNumber = orderNumber;
		this.deleteNumber = deleteNumber;
	}

	// getter setter
	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public int getDeleteNumber() {
		return deleteNumber;
	}
	public void setDeleteNumber(int deleteNumber) {
		this.deleteNumber = deleteNumber;
	}

}
