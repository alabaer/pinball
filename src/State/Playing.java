package State;

import AbstractFactory.DisplayText;
import FlipperElements.Element;
import Visitor.Pointsvisitor;

import java.util.ArrayList;
import java.util.Random;

public class Playing extends State {
    private final Flipper flipper;


    public Playing(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("coindrop");
        displayText.create();
        flipper.setCredit(flipper.getCredit() + 1);
        System.out.println("Credits: " + flipper.getCredit());
    }

    @Override
    public void pressStart() {
        System.out.println("David & Magdalena");
    }

    public void playBall() throws InterruptedException {
        Random random = new Random();
        while (flipper.getBalls() > 0) {
            int randomNumber = random.nextInt(5);
            ArrayList<Element> flipperElements = flipper.getElements();
            flipperElements.get(randomNumber).hit();
        }
    }

    public void endOfRound() throws InterruptedException {
        int sum = 0;
        Pointsvisitor visitor = new Pointsvisitor();
        ArrayList<Element> flipperElements = flipper.getElements();
        for (Element element : flipperElements) {
            sum += element.acceptScoreVisitor(visitor);
        }
        flipper.getScoreboard().addScore(sum);
        System.out.println("Your points this round are: " + sum);
        if (flipper.getBalls() > 0) {
            System.out.println("Next ball in 3 Seconds");
            Thread.sleep(3000);
            playBall();
        }
        end();
    }

    public void end() {
        flipper.setState(new Endstate(flipper));
    }
}
