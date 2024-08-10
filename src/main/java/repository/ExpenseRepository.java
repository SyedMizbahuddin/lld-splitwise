package repository;

import model.Expense;

public class ExpenseRepository extends AbstractRepository<Expense> {

	private static final ExpenseRepository instance = new ExpenseRepository();

	private ExpenseRepository() {

	}

	public static ExpenseRepository getInstance() {
		return instance;
	}
}
