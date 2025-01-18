package Command;

import State.Flipper;

public class LoseBallCommand implements Command {
    private Flipper flipper;

    @Override
    public void execute() {
        flipper.setBalls(flipper.getBalls() - 1);
    }
}
