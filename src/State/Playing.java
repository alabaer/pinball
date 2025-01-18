package State;

public class Playing extends State {
    private final Flipper flipper;

    public Playing(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        //Placeholder
        System.out.println("You are already Playing");
    }

    @Override
    public void pressStart() {
        //Placeholder abstract factory
        System.out.println("David & Magdalena");
    }

    //Placeholder Playing Logik

    public void end(){
        flipper.setState(new Endstate(flipper));
    }
}
