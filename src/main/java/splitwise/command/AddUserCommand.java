package splitwise.command;

import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;

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
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public boolean valid(String[] token) {
		return token.length > 1;
	}

}
