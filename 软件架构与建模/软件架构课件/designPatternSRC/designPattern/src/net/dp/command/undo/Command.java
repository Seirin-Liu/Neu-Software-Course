package net.dp.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
