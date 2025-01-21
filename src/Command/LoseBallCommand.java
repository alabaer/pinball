package Command;

import State.Flipper;

public class LoseBallCommand implements Command {
    private Flipper flipper;

    public LoseBallCommand(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void execute() throws InterruptedException {

        flipper.setBalls(flipper.getBalls() - 1);
        Thread.sleep(1000);
    }
}
