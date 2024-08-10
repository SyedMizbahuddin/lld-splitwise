package command;

import java.util.HashMap;
import java.util.Map;

import exception.CommandNotFoundException;
import service.SplitwiseService;
import writer.OutputWriter;

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
		commands.put(AddExpenseCommand.commandName, new AddExpenseCommand(splitwiseService, writer));
		commands.put(ListExpenseCommand.commandName, new ListExpenseCommand(splitwiseService, writer));
		commands.put(ListDebtCommand.commandName, new ListDebtCommand(splitwiseService, writer));
	}

	public Command getCommand(String commandName) {
		if (!commands.containsKey(commandName)) {
			throw new CommandNotFoundException(commandName + " Command not found");
		}
//		writer.printNewLine("CommandFactory found command " + commandName);
		return commands.get(commandName);
	}
}
