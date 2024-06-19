package model;

import java.io.Serializable;

public class Active implements Serializable {
	private int activeNumber;		//運動番号
	private int kind;				//運動種類
	private double metsValue;		//運動ごとのメッツ値
	private String activeName;		//運動名

	public Active() {

	}
	public Active(int activeNumber, int kind, double metsValue, String activeName) {
		super();
		this.activeNumber = activeNumber;
		this.kind = kind;
		this.metsValue = metsValue;
		this.activeName = activeName;
	}

	// getter setter
	public int getActiveNumber() {
		return activeNumber;
	}
	public void setActiveNumber(int activeNumber) {
		this.activeNumber = activeNumber;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public double getMetsValue() {
		return metsValue;
	}
	public void setMetsValue(double metsValue) {
		this.metsValue = metsValue;
	}
	public String getActiveName() {
		return activeName;
	}
	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

}
