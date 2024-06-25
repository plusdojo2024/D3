package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LoginUser extends User implements Serializable {
	private List<Level> lvList;
	private List<Comment> comList;
	private List<Active> acList;
	private List<DayResult> drList; // ログインユーザーのDayResultのリスト
	private List<GroupMember> gmList; // ログインユーザーが入っているグループのリスト


	public LoginUser() {

	}
	public LoginUser(User user) {
		super(
				user.getNumber(),
				user.getId(),
				user.getPassword(),
				user.getName(),
				user.getHeight(),
				user.getWeight(),
				user.getBmi(),
				user.getUserLevel(),
				user.getUserExp()
		);
	}

	// getter setter
	public List<Level> getLvList() {
		return lvList;
	}
	public Level getPickupLvList(int level) {	// Listの一要素だけ取得するgetter
		Level pickupLevel = null;
		for(Level search : this.lvList) {
			if(search.getLevel() == level) {
				pickupLevel = search;
			}
		}
		return pickupLevel;
		// nullのままだったら例外処理
		// →必ず存在する値を検索するため、nullのままはありえないから書いてない
	}
	public void setLvList(List<Level> lvList) {
		this.lvList = lvList;
	}

	public List<Comment> getComList() {
		return comList;
	}
	public Comment getPickupComList(int commentNum) {	// Listの一要素だけ取得するgetter
		Comment pickupComment = null;
		for(Comment search : this.comList) {
			if(search.getCommentNumber() == commentNum) {
				pickupComment = search;
			}
		}
		return pickupComment;
	}
	public void setComList(List<Comment> comList) {
		this.comList = comList;
	}

	public List<Active> getAcList() {
		return acList;
	}
	public Active getPickupAcList(int activeNum) {	// Listの一要素だけ取得するgetter
		Active pickupActive = null;
		for(Active search : this.acList) {
			if(search.getActiveNumber() == activeNum) {
				pickupActive = search;
			}
		}
		return pickupActive;
	}
	public void setAcList(List<Active> acList) {
		this.acList = acList;
	}

	public List<DayResult> getDrList() {
		return drList;
	}
	public int getDayJudge(int y, int m, int d) {	// drList内の指定した日のjudgeを取得するgetter
		int dayJudge = 0;

		for(DayResult search : this.drList) {
			Date targetDate = search.getDate();
			int year = targetDate.getYear() + 1900;
			int month = targetDate.getMonth()+1;
			int day = targetDate.getDate();
			if(y == year && m == month && d == day) {
				dayJudge = search.getJudge();
			}
		}
		return dayJudge;
	}
	public void setDrList(List<DayResult> drList) {
		this.drList = drList;
	}

	public List<GroupMember> getGmList() {
		return gmList;
	}
	public void setGmList(List<GroupMember> gmList) {
		this.gmList = gmList;
	}

}
