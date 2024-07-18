package splitwise.model;

public class Expense extends Entity {

	String name;
	double amount;
	int debtorId;

	public Expense(String name, double amount, int debtorId) {
		super();
		this.name = name;
		this.amount = amount;
		this.debtorId = debtorId;
	}

}
