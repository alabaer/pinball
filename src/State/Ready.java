package State;

import AbstractFactory.DisplayText;

public class Ready extends State {
    private final Flipper flipper;


    public Ready(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() throws InterruptedException {
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("coindrop");
        displayText.create();
        flipper.addCredit();
        flipper.userInterface();
    }

    @Override
    public void pressStart() throws InterruptedException {
        flipper.createFlipper();
        flipper.setBalls(3);
        flipper.setCredit(flipper.getCredit() - 1);
        System.out.println("Start Game");
        Thread.sleep(1000);
        Playing playing = new Playing(flipper);
        flipper.setState(playing);
        playing.playBall();
    }
}
