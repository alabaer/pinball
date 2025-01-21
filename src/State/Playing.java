package State;

import AbstractFactory.DisplayText;
import FlipperElements.Element;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

import java.util.ArrayList;
import java.util.Scanner;

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
        while (flipper.getIsRunning()) {
            flipper.getFlipperElementCompositum().hit();
        }
        endOfRound();
    }

    public void endOfRound() throws InterruptedException {
        int sum = 0;
        Pointsvisitor visitor = new Pointsvisitor();
        Resetvisitor reset = new Resetvisitor();
        ArrayList<Element> flipperElements = flipper.getFlipperElementCompositum().getElements();
        for (Element element : flipperElements) {
            sum += element.acceptScoreVisitor(visitor);
            element.acceptResetVisitor(reset);
        }
        flipper.getScoreboard().addScore(sum);
        flipper.getScoreboard().printroundScore();
        flipper.getScoreboard().setRoundScore(0);
        if (flipper.getBalls() > 0) {
            options();
        } else {
            end();
        }
    }

    public void end() throws InterruptedException {
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("gameover");
        displayText.create();
        flipper.getScoreboard().printTotalScore();
        flipper.getScoreboard().setTotalScore(0);
        flipper.setState(new Endstate(flipper));
        flipper.text();
    }

    public void options() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean waitingToContinue = true;

        while (waitingToContinue) {
            System.out.println("Press 1 to continue \nPress 2 to press Start \nPress 3 to insert Coin");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Next ball in 3 Seconds");
                    Thread.sleep(3000);
                    waitingToContinue = false;
                    flipper.setIsRunning(true);
                    playBall();

                    break;

                case 2:
                    pressStart();
                    break;

                case 3:
                    insertCoin();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }
}

