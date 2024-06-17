package model;

import java.io.Serializable;

public class User implements Serializable {
	private int number;		//
	private String id;			// ID
	private String password;	// password
	private String name;		//
	private double height;		//
	private double weight;		//
	private double bmi;		//
	private int userLevel;		//
	private int userExp;		//

	public User() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public User(int number, String id, String password, String name, double height, double weight, double bmi,
			int userLevel, int userExp) {
		super();
		this.number = number;
		this.id = id;
		this.password = password;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.userLevel = userLevel;
		this.userExp = userExp;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public int getUserExp() {
		return userExp;
	}
	public void setUserExp(int userExp) {
		this.userExp = userExp;
	}

}
