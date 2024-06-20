package model;

import java.io.Serializable;

public class GroupList implements Serializable {
	private int groupNumber;
	private	 int groupId;
	private String groupName;

	public GroupList() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public GroupList(int groupNumber, int groupId, String groupName) {
		this.groupNumber = groupNumber;
		this.groupId = groupId;
		this.groupName = groupName;
	}

	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
