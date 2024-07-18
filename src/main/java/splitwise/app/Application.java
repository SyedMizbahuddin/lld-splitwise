package splitwise.app;

import splitwise.command.CommandFactory;
import splitwise.mode.InteractiveMode;
import splitwise.mode.Mode;
import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;
import splitwise.writer.SystemWriter;

public class Application {

	public static void main(String[] args) {

		OutputWriter outputWriter = new SystemWriter();
		SplitwiseService splitwiseService = new SplitwiseService(outputWriter);
		CommandFactory commandFactory = new CommandFactory(splitwiseService, outputWriter);

		Mode mode = new InteractiveMode(commandFactory);

		mode.start();
	}

}
