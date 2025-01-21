package Command;

import AbstractFactory.*;
import State.Flipper;

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
        flipper.setIsRunning(false);
    }
}
