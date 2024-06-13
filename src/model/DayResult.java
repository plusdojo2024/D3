package model;

import java.io.Serializable;
import java.util.Date;


public class DayResult implements Serializable{
	private Date date;/*日付*/
	private double goalKcal;/*目標カロリー*/
	private double resultKcal;/*達成カロリー*/
	private int judge;/*達成判断*/
	private int number;/*ユーザー番号*/
	
	
	
	public DayResult() {
		super();
		this.date = null;
		this.goalKcal = 100.0;
		this.resultKcal = 70.0;
		this.judge = 1;
		this.number = 1;
	}


	public DayResult(Date date, double goalKcal, double resultKcal, int judge, int number) {
		super();
		this.date = date;
		this.goalKcal = goalKcal;
		this.resultKcal = resultKcal;
		this.judge = judge;
		this.number = number;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getGoalKcal() {
		return goalKcal;
	}


	public void setGoalKcal(double goalKcal) {
		this.goalKcal = goalKcal;
	}


	public double getResultKcal() {
		return resultKcal;
	}


	public void setResultKcal(double resultKcal) {
		this.resultKcal = resultKcal;
	}


	public int getJudge() {
		return judge;
	}


	public void setJudge(int judge) {
		this.judge = judge;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
	
	
}