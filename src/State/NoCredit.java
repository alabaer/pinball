package State;

import AbstractFactory.DisplayText;

public class NoCredit extends State {
    private final Flipper flipper;

    public NoCredit(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() throws InterruptedException {
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("coindrop");
        displayText.create();
        flipper.setCredit(flipper.getCredit() + 1);
        System.out.println("Credits: " + flipper.getCredit());
        flipper.setState(new Ready(flipper));
        flipper.userInterface();
    }

    @Override
    public void pressStart() throws InterruptedException {
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("nocredit");
        displayText.create();
        flipper.userInterface();
    }
}
