package splitwise.command;

import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;

public class ListExpenseCommand extends Command {

	ListExpenseCommand(SplitwiseService splitwiseService, OutputWriter writer) {
		super(splitwiseService, writer);
	}

	public static final String commandName = "list_expenses";

	@Override
	public void execute(String[] token) {
		super.execute(token);
		splitwiseService.listExpenses();
		writer.printNewLine("");
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public ValidationCheck valid(String[] token) {
		return check(token.length == 1, "require exactly 1 tokens");
	}

}
