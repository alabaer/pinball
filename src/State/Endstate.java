package State;

import AbstractFactory.DisplayText;

public class Endstate extends State {
    private Flipper flipper;

    public Endstate(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("coindrop");
        displayText.create();
        flipper.setCredit(flipper.getCredit()+1);
        flipper.setState(new Ready(flipper));
    }

    @Override
    public void pressStart() {
        System.out.println("Insert Coins");
    }
}
