package splitwise.mode;

import splitwise.command.CommandFactory;

public abstract class Mode {

	CommandFactory commandFactory;

	public Mode(CommandFactory commandFactory) {
		super();
		this.commandFactory = commandFactory;
	}

	public abstract void start();
}
