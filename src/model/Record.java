package model;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {
	private int recordNumber;
	private int kind;
	private double value;
	private String unit;
	private Date registDate;
	private int number;
	private double kcal;
	private String name;
	public Record() {
		super();
		this.recordNumber = 0;
		this.kind = 0;
		this.value = 0.0;
		this.unit = "分";
		this.registDate = null;
		this.number = 0;
		this.kcal = 0.0;
		this.name = "";
	}
	public Record(int recordNumber, int kind, double value, String unit, Date registDate, int number, double kcal, String name) {
		super();
		this.recordNumber = recordNumber;
		this.kind = kind;
		this.value = value;
		this.unit = unit;
		this.registDate = registDate;
		this.number = number;
		this.kcal = kcal;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getKcal() {
		return kcal;
	}
	public void setKcal(double kcal) {
		this.kcal = kcal;
	}



}
