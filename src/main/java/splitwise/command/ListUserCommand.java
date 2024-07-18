package splitwise.command;

import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;

public class ListUserCommand extends Command {

	ListUserCommand(SplitwiseService splitwiseService, OutputWriter writer) {
		super(splitwiseService, writer);
	}

	public static final String commandName = "list_users";

	@Override
	public void execute(String[] token) {
		super.execute(token);
		splitwiseService.listUsers();
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
