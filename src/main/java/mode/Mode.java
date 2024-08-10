package mode;

import command.CommandFactory;

public abstract class Mode {

	CommandFactory commandFactory;

	public Mode(CommandFactory commandFactory) {
		super();
		this.commandFactory = commandFactory;
	}

	public abstract void start();
}
