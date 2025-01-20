package State;

import AbstractFactory.DisplayText;

public class NoCredit extends State {
    private final Flipper flipper;

    public NoCredit(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("coindrop");
        displayText.create();
        flipper.createFlipper();
        flipper.setCredit(flipper.getCredit() + 1);
        System.out.println("Credits: " + flipper.getCredit());
        flipper.setState(new Ready(flipper));


    }

    @Override
    public void pressStart() {
        System.out.println("No credit entered");

    }
}
