package splitwise.command;

import java.util.ArrayList;
import java.util.List;

import splitwise.model.DividedAmount;
import splitwise.service.SplitwiseService;
import splitwise.service.divide.DivideFactory;
import splitwise.service.divide.DivideStrategy;
import splitwise.writer.OutputWriter;

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
		for (int i = 0; i < totalDebtees; i++) {
			divison.add(Integer.parseInt(token[ind++]));
		}

		DivideStrategy divideStrategy = divideFactory.getDivideStrategy(format);
		List<DividedAmount> dividedAmount = divideStrategy.divide(amount, debtees, divison);

		splitwiseService.addExpense(token[1], amount, paidBy, dividedAmount);

		writer.printNewLine("New expense added");

	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public boolean valid(String[] token) {
		// add_expense name paidBy format count x x x amount (x x x)
		// atleast 5
		if (token.length < 8) {
			return false;
		}

		try {
			int paidBy = Integer.parseInt(token[2]);
			String format = token[3];

			if (!divideFactory.valid(format)) {
				return false;
			}
			int totalDebtees = Integer.parseInt(token[4]);
			// Now the rest length should be
			// possibility1 : 1 + count + 1 + count = 2 * count + 2
			// possibility2 : 1 + count + 1 + 0 = count + 2

			int restLength = token.length - 4;

			if (restLength != totalDebtees + 2 && restLength != 2 * totalDebtees + 2) {
				return false;
			}

			// from count all are int
			for (int i = 4; i < token.length; i++) {
				int isNumber = Integer.parseInt(token[i]);
			}
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

}
