package State;

public class Ready extends State {
    private final Flipper flipper;


    public Ready(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        flipper.setCredit(flipper.getCredit() + 1);
        System.out.println("Credits: " + flipper.getCredit());
    }

    @Override
    public void pressStart() throws InterruptedException {
        flipper.createFlipper();
        flipper.setCredit(flipper.getCredit() - 1);
        System.out.println("Flipper was Created");
        System.out.println("Start Game");
       Thread.sleep(1000);
        flipper.setState(new Playing(flipper));
        ((Playing) flipper.getState()).playBall();    }
}
