package command;

import java.util.ArrayList;
import java.util.List;

import model.DividedAmount;
import service.SplitwiseService;
import service.divide.DivideFactory;
import service.divide.DivideStrategy;
import writer.OutputWriter;

public class AddExpenseCommand extends Command {

	DivideFactory divideFactory;

	AddExpenseCommand(SplitwiseService splitwiseService, OutputWriter writer) {
		super(splitwiseService, writer);
		this.divideFactory = new DivideFactory();
	}

	public static final String commandName = "add_expense";

	@Override
	public void execute(String[] token) {
		super.execute(token);
		// add_expense name paidBy format count x x x amount (x x x)
		String expenseName = token[1];
		int paidBy = Integer.parseInt(token[2]);
		String format = token[3];

		int totalDebtees = Integer.parseInt(token[4]);
		List<Integer> debtees = new ArrayList<>();

		int ind = 5;
		for (int i = 0; i < totalDebtees; i++) {
			debtees.add(Integer.parseInt(token[ind++]));
		}

		int amount = Integer.parseInt(token[ind++]);

		List<Integer> divison = new ArrayList<>();
		for (int i = 0; i < totalDebtees && ind < token.length; i++) {
			divison.add(Integer.parseInt(token[ind++]));
		}

		DivideStrategy divideStrategy = divideFactory.getDivideStrategy(format);
		List<DividedAmount> dividedAmount = divideStrategy.divide(amount, debtees, divison);

		splitwiseService.addExpense(token[1], amount, paidBy, dividedAmount);

		writer.printNewLine("New expense added");
		writer.printNewLine("");

	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public ValidationCheck valid(String[] token) {
		// add_expense name paidBy format count x x x amount (x x x)
		// atleast 5
		if (token.length < 8) {
			return check(false, "require atleast 8 tokens");
		}

		try {
			int paidBy = Integer.parseInt(token[2]);
			String format = token[3];

			if (!divideFactory.valid(format)) {
				return check(false, format + " format does not exist");
			}
			int totalDebtees = Integer.parseInt(token[4]);
			// Now the rest length should be
			// possibility1 : 1 + count + 1 + count = 2 * count + 2
			// possibility2 : 1 + count + 1 + 0 = count + 2

			int restLength = token.length - 4;

			if (restLength != totalDebtees + 2 && restLength != 2 * totalDebtees + 2) {
				return check(false, "insufficient token length");
			}

			if (!splitwiseService.userExists(paidBy)) {
				return check(false, "debtor user with id " + paidBy + " does not exist");
			}

			// from count all are int
			int ind = 5;
			for (int i = 0; i < totalDebtees; i++) {
				int debteeId = Integer.parseInt(token[ind++]);

				if (!splitwiseService.userExists(debteeId)) {
					return check(false, "debtee user with id " + debteeId + " does not exist");
				}

//				if (debteeId == paidBy) {
//					return check(false, "debtee user with id " + debteeId + " is also the debtor");
//				}
			}

			int amount = Integer.parseInt(token[ind++]);

			List<Integer> divison = new ArrayList<>();
			for (int i = 0; i < totalDebtees && ind < token.length; i++) {
				divison.add(Integer.parseInt(token[ind++]));
			}

		} catch (NumberFormatException e) {
			return check(false, e.getMessage());
		}

		return check(true);
	}

}
