package splitwise.command;

import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;

public class ListDebtCommand extends Command {

	ListDebtCommand(SplitwiseService splitwiseService, OutputWriter writer) {
		super(splitwiseService, writer);
	}

	public static final String commandName = "list_debts";

	@Override
	public void execute(String[] token) {
		super.execute(token);
		int userId = Integer.parseInt(token[1]);
		splitwiseService.listDebts(userId);
		writer.printNewLine("");
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public ValidationCheck valid(String[] token) {
		if (token.length != 2) {
			return check(false, "require exactly 2 tokens");
		}

		int userId = Integer.parseInt(token[1]);
		if (!splitwiseService.userExists(userId)) {
			return check(false, "user with " + userId + " does not exist");
		}
		return check(true);
	}

}
