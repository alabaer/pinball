package State;

import AbstractFactory.DisplayText;

public class Endstate extends State {
    private Flipper flipper;

    public Endstate(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        System.out.println("Nothing happens");
    }

    @Override
    public void pressStart() {
        if (flipper.getCredit() > 0) {
            flipper.setState(new Ready(flipper));
        }
        flipper.setState(new NoCredit(flipper));
    }
}
