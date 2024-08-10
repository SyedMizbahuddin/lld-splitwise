package model;

public class DividedAmount {
	int debteeId;
	double amount;

	public DividedAmount(int debteeId, double amount) {
		super();
		this.debteeId = debteeId;
		this.amount = amount;
	}

	public int getDebteeId() {
		return debteeId;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "{ debteeId=" + debteeId + ", amount=" + amount + " }";
	}

}
