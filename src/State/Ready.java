package State;

public class Ready extends State {
    private final Flipper flipper;


    public Ready(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        System.out.println("No coin needed");
    }

    @Override
    public void pressStart() {
        System.out.println("Start Game");
        flipper.setState(new Playing(flipper));
    }
}
