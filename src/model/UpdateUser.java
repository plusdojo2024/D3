package model;

import java.io.Serializable;

public class UpdateUser extends User implements Serializable {
	private boolean updateOk;

	public UpdateUser() {

	}
	public UpdateUser(User user) {
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
	public UpdateUser(User user, boolean updateOk) {
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
		this.updateOk = updateOk;
	}
	public boolean isUpdateOk() {
		return updateOk;
	}
	public void setUpdateOk(boolean updateOk) {
		this.updateOk = updateOk;
	}

}
