package mode;

import java.util.Scanner;

import command.Command;
import command.CommandFactory;

public class InteractiveMode extends Mode {

	public InteractiveMode(CommandFactory commandFactory) {
		super(commandFactory);
	}

	@Override
	public void start() {
		Scanner in = new Scanner(System.in);

		while (true) {
			String line = in.nextLine();
			String[] tokens = line.split(" ");

			Command command = commandFactory.getCommand(tokens[0]);
			command.execute(tokens);
		}
	}

}
