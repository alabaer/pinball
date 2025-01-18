package Command;

import FlipperElements.Elements;

import java.util.ArrayList;
import java.util.List;

public class HitAndChangeState implements Command {
    private final List<Command> commands;

    public HitAndChangeState(List<Command> commands) {
        this.commands = commands;
        commands = new ArrayList<Command>(commands);
        commands.add(new HitCommand());
        commands.add(new ChangeStateCommand());
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

