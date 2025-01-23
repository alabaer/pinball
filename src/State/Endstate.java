package State;


public class Endstate extends State {
    private Flipper flipper;

    public Endstate(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() throws InterruptedException {
        System.out.println("Nothing happens. Press start");
        flipper.userInterface();
    }

    @Override
    public void pressStart() throws InterruptedException {
        if (flipper.getCredit() > 0) {
            Ready ready = new Ready(flipper);
            flipper.setState(ready);
            ready.pressStart();
        } else {
            flipper.setState(new NoCredit(flipper));
            flipper.userInterface();
        }
    }
}
