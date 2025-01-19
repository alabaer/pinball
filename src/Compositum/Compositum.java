package Compositum;

import Command.Command;

import java.util.ArrayList;
import java.util.List;

public class Compositum implements Command {
    private List<Command> commands;

    public Compositum() {
        this.commands = new ArrayList<Command>();
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
