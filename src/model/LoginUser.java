package model;

import java.io.Serializable;
import java.util.List;

public class LoginUser extends User implements Serializable {
	private List<Level> lvList;
	private List<Comment> comList;
	private List<Active> acList;
	private List<GroupList> gmList; // ログインユーザーが入っているグループのリスト

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
		Level PickupLevel = null;
		for(Level search : this.lvList) {
			if(search.getLevel() == level) {
				PickupLevel = search;
			}
		}
		return PickupLevel;
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
		Comment PickupComment = null;
		for(Comment search : this.comList) {
			if(search.getCommentNumber() == commentNum) {
				PickupComment = search;
			}
		}
		return PickupComment;
	}
	public void setComList(List<Comment> comList) {
		this.comList = comList;
	}

	public List<Active> getAcList() {
		return acList;
	}
	public Active getPickupAcList(int activeNum) {	// Listの一要素だけ取得するgetter
		Active PickupActive = null;
		for(Active search : this.acList) {
			if(search.getActiveNumber() == activeNum) {
				PickupActive = search;
			}
		}
		return PickupActive;
	}
	public void setAcList(List<Active> acList) {
		this.acList = acList;
	}

	public List<GroupList> getGmList() {
		return gmList;
	}
	public void setGmList(List<GroupList> gmList) {
		this.gmList = gmList;
	}

}
