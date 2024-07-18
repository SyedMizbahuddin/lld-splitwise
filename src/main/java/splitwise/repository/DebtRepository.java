package splitwise.repository;

import java.util.List;
import java.util.stream.Collectors;

import splitwise.model.Debt;

public class DebtRepository extends AbstractRepository<Debt> {

	private static final DebtRepository instance = new DebtRepository();

	private DebtRepository() {

	}

	public static DebtRepository getInstance() {
		return instance;
	}

	public List<Debt> findByExpenseId(int expenseId) {
		return this.repository.values()
				.stream()
				.filter(debt -> debt.getExpenseId() == expenseId)
				.collect(Collectors.toList());
	}
}
