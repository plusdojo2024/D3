package model;

import java.util.Date;

public class Result extends DayResult {
	
	private double startIdo; 
	private double startKeido;
	private double endIdo; 
	private double endKeido;
	private int moveKind; 
	private double distance; 
	private double kcal; 
	private int kind; 
	private int value; 
	private int unit; 
	private Date registDate;
	
	
	public Result(double startIdo, double startKeido, double endIdo, double endKeido, int moveKind, double distance,
			double kcal, int kind, int value, int unit, Date registDate) {
		super();
		this.startIdo = startIdo;
		this.startKeido = startKeido;
		this.endIdo = endIdo;
		this.endKeido = endKeido;
		this.moveKind = moveKind;
		this.distance = distance;
		this.kcal = kcal;
		this.kind = kind;
		this.value = value;
		this.unit = unit;
		this.registDate = registDate;
	}


	public Result() {
		super();
		this.startIdo = 0.0;
		this.startKeido = 0.0;
		this.endIdo = 0.0;
		this.endKeido = 0.0;
		this.moveKind = 1;
		this.distance = 1;
		this.kcal = 30;
		this.kind = 1;
		this.value = 2;
		this.unit = 1;
		this.registDate = null;
	}


	
	public double getStartIdo() {
		return startIdo;
	}


	public void setStartIdo(double startIdo) {
		this.startIdo = startIdo;
	}


	public double getStartKeido() {
		return startKeido;
	}


	public void setStartKeido(double startKeido) {
		this.startKeido = startKeido;
	}


	public double getEndIdo() {
		return endIdo;
	}


	public void setEndIdo(double endIdo) {
		this.endIdo = endIdo;
	}


	public double getEndKeido() {
		return endKeido;
	}


	public void setEndKeido(double endKeido) {
		this.endKeido = endKeido;
	}


	public int getMoveKind() {
		return moveKind;
	}


	public void setMoveKind(int moveKind) {
		this.moveKind = moveKind;
	}


	public double getDistance() {
		return distance;
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}


	public double getKcal() {
		return kcal;
	}


	public void setKcal(double kcal) {
		this.kcal = kcal;
	}


	public int getKind() {
		return kind;
	}


	public void setKind(int kind) {
		this.kind = kind;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int getUnit() {
		return unit;
	}


	public void setUnit(int unit) {
		this.unit = unit;
	}


	public Date getRegistDate() {
		return registDate;
	}


	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	
}