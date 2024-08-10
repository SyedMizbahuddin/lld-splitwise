package command;

import exception.IncorrectCommandException;
import service.SplitwiseService;
import writer.OutputWriter;

public abstract class Command {

	OutputWriter writer;
	SplitwiseService splitwiseService;

	Command(SplitwiseService splitwiseService, OutputWriter writer) {
		this.writer = writer;
		this.splitwiseService = splitwiseService;
	}

	public void execute(String[] token) {
		ValidationCheck validationCheck = valid(token);
		if (!validationCheck.valid()) {
			throw new IncorrectCommandException("Incorrect Command token for " + getCommandName() + " : "
					+ validationCheck.message());
		}

//		writer.printNewLine("Executing command " + getCommandName());
	}

	public abstract ValidationCheck valid(String[] token);

	public abstract String getCommandName();

	public ValidationCheck check(boolean valid, String message) {
		return new ValidationCheck(valid, message);
	}

	public ValidationCheck check(boolean valid) {
		return new ValidationCheck(valid, "");
	}
}
