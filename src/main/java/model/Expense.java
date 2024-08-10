package model;

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

	@Override
	public String toString() {
		return "{ name=" + name + ", amount=" + amount + ", debtorId=" + debtorId + " }";
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public int getDebtorId() {
		return debtorId;
	}

}
