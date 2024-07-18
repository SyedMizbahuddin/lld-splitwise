package splitwise.repository;

import splitwise.model.Debt;

public class DebtRepository extends AbstractRepository<Debt> {

	private static final DebtRepository instance = new DebtRepository();

	private DebtRepository() {

	}

	public static DebtRepository getInstance() {
		return instance;
	}
}
