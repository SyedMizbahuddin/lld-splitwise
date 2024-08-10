package command;

import service.SplitwiseService;
import writer.OutputWriter;

public class ListUserCommand extends Command {

	ListUserCommand(SplitwiseService splitwiseService, OutputWriter writer) {
		super(splitwiseService, writer);
	}

	public static final String commandName = "list_users";

	@Override
	public void execute(String[] token) {
		super.execute(token);
		splitwiseService.listUsers();
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
