package State;

import AbstractFactory.*;
import Adapter.Flashinglights;
import Adapter.FlashinglightsCommandAdapter;
import Compositum.CommandCompositum;
import Compositum.FlipperElementCompositum;
import FlipperElements.*;
import Mediator.*;
import Command.*;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Flipper {
    private static Flipper instance;
    private State state;
    private AbstractFactory<DisplayText> factory = null;
    private DisplayText displayText;
    private int credit;
    private ArrayList<Element> elements;
    private int balls = 3;
    private final TargetMediator mediator = new TargetMediator();
    private final Scoreboard scoreboard = new Scoreboard();

    public int getCredit() {
        return this.credit;
    }

    public AbstractFactory<DisplayText> getDisplayTextFactory() {
        return this.factory;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
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

    public void text() throws InterruptedException {
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
        text();
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
                text();
                break;
            case 2:
                AbstractFactoryB textB = new AbstractFactoryB();
                this.factory = textB;
                text();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                chooseFont();
                break;
        }
    }
//refactoren wo es gut dazupasst
    public Command createCommand() {
        Random random = new Random();
        LoseBallCommand loseBallCommand = new LoseBallCommand(this);
        Minigame minigame = new Minigame(scoreboard);
        LuckyShot luckyShot = new LuckyShot(scoreboard);
        Flashinglights flash = new Flashinglights();
        ArrayList<Command> commands = new ArrayList<>();
        FlashinglightsCommandAdapter flashinglightsCommandAdapter = new FlashinglightsCommandAdapter(flash);
        CommandCompositum commandCompositum = new CommandCompositum();
        commandCompositum.addCommand(luckyShot);
        commandCompositum.addCommand(flashinglightsCommandAdapter);
        commands.add(loseBallCommand);
        commands.add(commandCompositum);
        commands.add(minigame);
        int randomNumber = random.nextInt(3);
        return commands.get(randomNumber);
    }
//refactoren wo es gut dazu passt
    public void createFlipper() {
        elements = new ArrayList<>();
        Target target1 = new Target(createCommand(),this.mediator);
        Target target2 = new Target(createCommand(),this.mediator);
        Target target3 = new Target(createCommand(),this.mediator);
        Ramp ramp = new Ramp(createCommand(),this.mediator);
        Bumper bumper1 = new Bumper(createCommand());
        elements.add(bumper1);
        Bumper bumper2 = new Bumper(createCommand());
        elements.add(bumper2);
        Hole hole = new Hole(createCommand());
        elements.add(hole);
        Slingshot slingshot = new Slingshot(createCommand());
        elements.add(slingshot);
        FlipperElementCompositum compositum = new FlipperElementCompositum(target1, target2, target3, ramp);
        mediator.addTargets(compositum.getElements());
        elements.add(compositum);
    }

    public AbstractFactory getDisplayText() {
        return factory;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }
}
