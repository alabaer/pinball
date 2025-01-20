package State;

public class NoCredit extends State {
    private final Flipper flipper;

    public NoCredit(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        flipper.setCredit(flipper.getCredit()+1);
        flipper.setState(new Ready(flipper));

    }

    @Override
    public void pressStart() {
        //Placeholder für Abstract Factory
        System.out.println("No credit entered");

    }
}
