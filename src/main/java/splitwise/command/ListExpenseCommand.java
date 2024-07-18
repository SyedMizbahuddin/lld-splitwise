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
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public boolean valid(String[] token) {
		return token.length == 1;
	}

}
