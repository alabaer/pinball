package Command;

import AbstractFactory.*;
import State.Flipper;
import State.Playing;

public class LoseBallCommand implements Command {
    private Flipper flipper;

    public LoseBallCommand(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void execute() throws InterruptedException {
        AbstractFactory<DisplayText> factory = flipper.getDisplayTextFactory();
        DisplayText displayText = factory.displayText("loseball");
        displayText.create();
        flipper.setBalls(flipper.getBalls() - 1);
        Thread.sleep(1000);
        ((Playing) flipper.getState()).endOfRound();
    }
}
