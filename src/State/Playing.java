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
        flipper.addCredit();
        System.out.println("New Credit: " + flipper.getCredit());
    }

    @Override
    public void pressStart() throws InterruptedException {
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
        flipper.getScoreboard().addRoundScore(sum);
        flipper.getScoreboard().addToTotalScore();
        flipper.getScoreboard().printRoundScore();
        flipper.getScoreboard().printTotalScore();
        flipper.getScoreboard().setRoundScore(0);
        if (flipper.getBalls() > 0) {
            options();
        } else {
            endOfGame();
        }
    }

    public void endOfGame() throws InterruptedException {
        flipper.setIsRunning(true);
        DisplayText displayText = flipper.getDisplayTextFactory().displayText("gameover");
        displayText.create();
        flipper.getScoreboard().printTotalScore();
        flipper.getScoreboard().setTotalScore(0);
        flipper.setBalls(3);
        flipper.setState(new Endstate(flipper));
        flipper.userInterface();
    }

    public void options() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean waitingToContinue = true;

        while (waitingToContinue) {
            System.out.println(("Remaining Balls: " + flipper.getBalls()));
            System.out.println("Press 1 to continue \nPress 2 to Start a new Game \nPress 3 to insert Coin");
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
                    flipper.resetGame();
                    flipper.setState(new Ready(flipper));
                    flipper.getState().pressStart();
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

