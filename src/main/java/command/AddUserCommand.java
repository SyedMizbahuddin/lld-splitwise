package command;

import service.SplitwiseService;
import writer.OutputWriter;

public class AddUserCommand extends Command {

	AddUserCommand(SplitwiseService splitwiseService, OutputWriter writer) {
		super(splitwiseService, writer);
	}

	public static final String commandName = "add_user";

	@Override
	public void execute(String[] token) {
		super.execute(token);
		int userId = splitwiseService.addUser(token[1]);
		writer.printNewLine("New user created with Id : " + userId);
		writer.printNewLine("");
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public ValidationCheck valid(String[] token) {
		// we expect only one words

		return check(token.length == 2, "require exactly 2 tokens");
	}

}
