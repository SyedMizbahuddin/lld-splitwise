package splitwise.command;

import java.util.HashMap;
import java.util.Map;

import splitwise.exception.CommandNotFoundException;
import splitwise.service.SplitwiseService;
import splitwise.writer.OutputWriter;

public class CommandFactory {

	Map<String, Command> commands;
	OutputWriter writer;
	SplitwiseService splitwiseService;

	public CommandFactory(SplitwiseService splitwiseService, OutputWriter writer) {
		commands = new HashMap<>();
		this.writer = writer;
		commands.put(ExitCommand.commandName, new ExitCommand(splitwiseService, writer));
		commands.put(AddUserCommand.commandName, new AddUserCommand(splitwiseService, writer));
		commands.put(ListUserCommand.commandName, new ListUserCommand(splitwiseService, writer));
	}

	public Command getCommand(String commandName) {
		if (!commands.containsKey(commandName)) {
			throw new CommandNotFoundException(commandName + " Command not found");
		}
		writer.printNewLine("CommandFactory found command " + commandName);
		return commands.get(commandName);
	}
}
