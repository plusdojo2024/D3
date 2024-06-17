package model;

import java.io.Serializable;
import java.util.List;

public class LoginUser extends User implements Serializable {
	private List<Level> lvList;
	private List<Comment> comList;
	private List<Active> acList;

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

	public List<Level> getLvList() {
		return lvList;
	}
	public Level getLvList(int level) {
		return this.lvList.get(level);
	}

	public void setLvList(List<Level> lvList) {
		this.lvList = lvList;
	}

	public List<Comment> getComList() {
		return comList;
	}

	public void setComList(List<Comment> comList) {
		this.comList = comList;
	}

	public List<Active> getAcList() {
		return acList;
	}

	public void setAcList(List<Active> acList) {
		this.acList = acList;
	}
}
