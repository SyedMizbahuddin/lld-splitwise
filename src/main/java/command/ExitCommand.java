package command;

import service.SplitwiseService;
import writer.OutputWriter;

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
	public ValidationCheck valid(String[] token) {
		return check(token.length == 1, "require exactly 1 tokens");
	}

}
