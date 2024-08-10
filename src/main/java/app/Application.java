package app;

import command.CommandFactory;
import mode.InteractiveMode;
import mode.Mode;
import service.SplitwiseService;
import writer.OutputWriter;
import writer.SystemWriter;

public class Application {

	public static void main(String[] args) {

		OutputWriter outputWriter = new SystemWriter();
		SplitwiseService splitwiseService = new SplitwiseService(outputWriter);
		CommandFactory commandFactory = new CommandFactory(splitwiseService, outputWriter);

		Mode mode = new InteractiveMode(commandFactory);

		mode.start();
	}

}
