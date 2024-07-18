package splitwise.command;

import splitwise.exception.IncorrectCommandException;
import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;

public abstract class Command {

	OutputWriter writer;
	SplitwiseService splitwiseService;

	Command(SplitwiseService splitwiseService, OutputWriter writer) {
		this.writer = writer;
		this.splitwiseService = splitwiseService;
	}

	public void execute(String[] token) {
		if (!valid(token)) {
			// TODO incorrect token exception
			throw new IncorrectCommandException("Incorrect Command token found");
		}
//		writer.printNewLine("Executing command " + getCommandName());
	}

	public abstract boolean valid(String[] token);

	public abstract String getCommandName();
}
