package application.telegramBot.handlers;


import application.telegramBot.commands.Command;
import application.telegramBot.reply.Reply;


public class CommandRequestHandler extends AbstractHandler{

	public CommandRequestHandler(Command command) {
		super(command);
	}

	@Override
	public Reply handleRequest() {
		return null;
	}
}
