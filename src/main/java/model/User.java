package model;

public class User extends Entity {
	String userName;

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "{userName=" + userName + ", id=" + id + "}";
	}

}
