package splitwise.command;

import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;

public class ExitCommand extends Command {

	ExitCommand(SplitwiseService splitwiseService, OutputWriter writer) {
		super(splitwiseService, writer);
	}

	public static final String commandName = "exit";

	@Override
	public void execute(String[] token) {
		super.execute(token);
		System.exit(1);
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
