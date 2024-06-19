package model;

import java.io.Serializable;

public class Level implements Serializable {
	private int level;			//レベル
	private double goalKcal;	//レベルごとの目標カロリー
	private int nextLevelExp;	//次のレベルまでに必要な達成日数

	public Level() {

	}
	public Level(int level, double goalKcal, int nextLevelExp) {
		super();
		this.level = level;
		this.goalKcal = goalKcal;
		this.nextLevelExp = nextLevelExp;
	}

	// getter setter
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getGoalKcal() {
		return goalKcal;
	}
	public void setGoalKcal(double goalKcal) {
		this.goalKcal = goalKcal;
	}
	public int getNextLevelExp() {
		return nextLevelExp;
	}
	public void setNextLevelExp(int nextLevelExp) {
		this.nextLevelExp = nextLevelExp;
	}

}
