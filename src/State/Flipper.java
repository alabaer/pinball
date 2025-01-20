package State;

import AbstractFactory.*;
import Compositum.FlipperElementCompositum;
import FlipperElements.*;
import Mediator.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Flipper {
    private static Flipper instance;
    private State state;
    private AbstractFactory factory = null;
    private DisplayText displayText;
    private int credit;
    private ArrayList<Element> elements;
    private int balls = 3;
    private final TargetMediator mediator = new TargetMediator();

    public int getCredit() {
        return this.credit;
    }

    public AbstractFactory<DisplayText> getDisplayTextFactory() {
        return this.factory;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getBalls() {
        return this.balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    private Flipper() {
        state = new NoCredit(this);
    }

    public static synchronized Flipper getInstance() {
        if (instance == null) {
            instance = new Flipper();
        }
        return instance;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void intro() throws InterruptedException {
        this.setState(this.state);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1: Enter Coin \n Press 2:Play \n Press 3: Exit \n Choice: " + this.state);
        int input = scanner.nextInt();
        if (input == 1) {
            this.state.insertCoin();
        } else if (input == 2) {
            this.state.pressStart();

        } else if (input == 3) {
            System.out.println("Exiting the program. Goodbye!");
            System.exit(0);
        } else System.out.println("Invalid input! Please try Again");
        intro();
    }

    public void chooseFont() throws InterruptedException {
        OptionA optionA = new OptionA();
        OptionB optionB = new OptionB();
        Scanner scanner = new Scanner(System.in);
        optionA.create();
        System.out.println("\n\n");
        optionB.create();
        System.out.println("Choose font to use. Press 1 for option A and 2 for option B. \n Input: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                AbstractFactoryA textA = new AbstractFactoryA();
                this.factory = textA;
                intro();
                break;
            case 2:
                AbstractFactoryB textB = new AbstractFactoryB();
                this.factory = textB;
                intro();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                chooseFont();
                break;
        }
    }

    public void createFlipper() {
        ArrayList<Element> flipperElements = new ArrayList<>();
        Target target1 = new Target(this.mediator);
        Target target2 = new Target(this.mediator);
        Target target3 = new Target(this.mediator);
        Ramp ramp = new Ramp(this.mediator);
        Bumper bumper1 = new Bumper();
        flipperElements.add(bumper1);
        Bumper bumper2 = new Bumper();
        flipperElements.add(bumper2);
        Hole hole = new Hole();
        flipperElements.add(hole);
        Slingshot slingshot = new Slingshot();
        flipperElements.add(slingshot);
        flipperElements.add(createCompositum(target1, target2, target3, ramp));

    }

    private FlipperElementCompositum createCompositum(Target target1, Target target2, Target target3, Ramp ramp3) {
        return new FlipperElementCompositum(target1, target2, target3, ramp3);
    }

    public AbstractFactory getDisplayText() {
        return factory;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }
}
