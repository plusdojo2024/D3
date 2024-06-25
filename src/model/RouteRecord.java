package model;

import java.io.Serializable;
import java.util.Date;

public class RouteRecord implements Serializable {
	private int 	 routeNumber;
	private double  startIdo;
	private double  startKeido;
	private double  endIdo;
	private double  endKeido;
	private double  distance;
	private int     moveKind;
	private double  kcal;
	private Date    registDate;
	private  int    number;
	private  String spot;
	public RouteRecord() {
		super();
		this.routeNumber = 0;
		this.startIdo = 0.0;
		this.startKeido = 0.0;
		this.endIdo = 0.0;
		this.endKeido = 0.0;
		this.distance = 0.0;
		this.moveKind = 0;
		this.kcal = 0.0;
		this.registDate = null;
		this.number = 0;
		this.spot = "";
	}
	public RouteRecord(double startIdo, double startKeido, double endIdo, double endKeido,
			double distance, int moveKind, double kcal, Date registDate, int number, String spot) {
		super();
		this.startIdo = startIdo;
		this.startKeido = startKeido;
		this.endIdo = endIdo;
		this.endKeido = endKeido;
		this.distance = distance;
		this.moveKind = moveKind;
		this.kcal = kcal;
		this.registDate = registDate;
		this.number = number;
		this.spot = spot;
	}
	public RouteRecord(int routeNumber, double startIdo, double startKeido, double endIdo, double endKeido,
			double distance, int moveKind, double kcal, Date registDate, int number, String spot) {
		super();
		this.routeNumber = routeNumber;
		this.startIdo = startIdo;
		this.startKeido = startKeido;
		this.endIdo = endIdo;
		this.endKeido = endKeido;
		this.distance = distance;
		this.moveKind = moveKind;
		this.kcal = kcal;
		this.registDate = registDate;
		this.number = number;
		this.spot = spot;
	}
	public int getRouteNumber() {
		return routeNumber;
	}
	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
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
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getMoveKind() {
		return moveKind;
	}
	public void setMoveKind(int moveKind) {
		this.moveKind = moveKind;
	}
	public double getKcal() {
		return kcal;
	}
	public void setKcal(double kcal) {
		this.kcal = kcal;
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
	public String getSpot() {
		return spot;
	}
	public void setSpot(String spot) {
		this.spot = spot;
	}

}
