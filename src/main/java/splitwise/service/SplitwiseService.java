package splitwise.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import splitwise.model.Debt;
import splitwise.model.DividedAmount;
import splitwise.model.Expense;
import splitwise.model.User;
import splitwise.repository.DebtRepository;
import splitwise.repository.ExpenseRepository;
import splitwise.repository.UserRepository;
import splitwise.writer.OutputWriter;

public class SplitwiseService {

	ExpenseRepository expenseRepository;
	DebtRepository debtRepository;
	UserRepository userRepository;
	OutputWriter writer;

	public SplitwiseService(OutputWriter writer) {
		this.expenseRepository = ExpenseRepository.getInstance();
		this.debtRepository = DebtRepository.getInstance();
		this.userRepository = UserRepository.getInstance();
		this.writer = writer;
	}

	public void addExpense(String name, double amount, int debtorId, List<DividedAmount> dividedAmount) {
		Expense expense = new Expense(name, amount, debtorId);
		expense = expenseRepository.add(expense);

		for (DividedAmount division : dividedAmount) {
			Debt debt = new Debt(debtorId, division.getDebteeId(), division.getAmount(), expense.getId());
			debtRepository.add(debt);
		}
	}

	public int addUser(String userName) {
		User user = new User(userName);
		userRepository.add(user);

		return user.getId();
	}

	public void listDebts(int userId) {
		Collection<Debt> allDebts = debtRepository.findAll();
		Iterator<Debt> iterator = allDebts.iterator();

		Map<Integer, Double> debtPerUser = new HashMap<>();

		while (iterator.hasNext()) {
			Debt currDebt = iterator.next();

			if (currDebt.getDebtorId() == userId) {
				debtPerUser.merge(currDebt.getDebteeId(), currDebt.getAmount(), Double::sum);
			}

			if (currDebt.getDebteeId() == userId) {
				debtPerUser.merge(currDebt.getDebtorId(), -currDebt.getAmount(), Double::sum);
			}
		}

		User user = userRepository.findById(userId);

		boolean balance = false;
		for (Entry<Integer, Double> currDebt : debtPerUser.entrySet()) {
			int otherUserId = currDebt.getKey();
			double amount = currDebt.getValue();

			if (amount == 0)
				continue;

			User debtorUser = user;
			User debteeUser = userRepository.findById(otherUserId);

			if (amount < 0) {
				writer.printNewLine(debtorUser.getUserName() + " to pay " + debteeUser.getUserName() + " : " + -amount);
			} else {
				writer.printNewLine(debtorUser.getUserName() + " owes " + debteeUser.getUserName() + " : " + amount);
			}
			balance = true;
		}

		if (!balance) {
			writer.printNewLine("No Balance");
		}

	}

	public void listUsers() {
		Collection<User> users = userRepository.findAll();
		Iterator<User> iterator = users.iterator();

		while (iterator.hasNext()) {
			User curr = iterator.next();
			writer.printNewLine("id : " + curr.getId() + "  name : " + curr.getUserName());
		}
	}

	public void listExpenses() {
		Collection<Expense> expenses = expenseRepository.findAll();
		Iterator<Expense> expenseIterator = expenses.iterator();

		while (expenseIterator.hasNext()) {
			Expense currExpense = expenseIterator.next();
			User debtor = userRepository.findById(currExpense.getDebtorId());
			writer.printNewLine(debtor.getUserName() + " paid " + currExpense.getAmount() + " for " + currExpense
					.getName());

			List<Debt> debts = debtRepository.findByExpenseId(currExpense.getId());
			Iterator<Debt> debtIterator = debts.iterator();

			while (debtIterator.hasNext()) {
				Debt currDebt = debtIterator.next();
				User debtee = userRepository.findById(currDebt.getDebteeId());

				writer.printNewLine(debtor.getUserName() + " owes " + debtee.getUserName() + " : " + currDebt
						.getAmount());
			}
			writer.printNewLine("");

		}
	}

	public boolean userExists(int userId) {
		return userRepository.existById(userId);
	}
}
