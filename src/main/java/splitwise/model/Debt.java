package splitwise.model;

public class Debt extends Entity {

	int debtorId;
	int debteeId;
	double amount;
	int expenseId;

	public Debt(int debtorId, int debteeId, double amount, int expenseId) {
		super();
		this.debtorId = debtorId;
		this.debteeId = debteeId;
		this.amount = amount;
		this.expenseId = expenseId;
	}

	public int getDebtorId() {
		return debtorId;
	}

	public int getDebteeId() {
		return debteeId;
	}

	public double getAmount() {
		return amount;
	}

	public int getExpenseId() {
		return expenseId;
	}

}
