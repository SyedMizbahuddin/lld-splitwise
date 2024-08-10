package repository;

import model.User;

public class UserRepository extends AbstractRepository<User> {

	private static final UserRepository instance = new UserRepository();

	private UserRepository() {

	}

	public static UserRepository getInstance() {
		return instance;
	}
}
