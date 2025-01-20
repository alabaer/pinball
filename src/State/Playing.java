package State;

public class Playing extends State {
    private final Flipper flipper;

    public Playing(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        flipper.setCredit(flipper.getCredit() + 1);
        System.out.println("Credits: " + flipper.getCredit());
    }

    @Override
    public void pressStart() {
        //Placeholder abstract factory
        System.out.println("David & Magdalena");
    }

    public void playBall(){

    }

    //Placeholder Playing Logik

    public void end() {
        flipper.setState(new Endstate(flipper));
    }
}
