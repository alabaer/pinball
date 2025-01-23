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

    public FlipperElementCompositum getFlipperElementCompositum() {
        return flipperElementCompositum;
    }

    private AbstractFactory<DisplayText> factory = null;
    private int credit;
    private FlipperElementCompositum flipperElementCompositum;
    private int balls = 3;
    private final TargetMediator mediator = new TargetMediator();
    private final Scoreboard scoreboard = new Scoreboard();
    private boolean isRunning = true;

    private Flipper() {
        state = new NoCredit(this);
    }

    public static synchronized Flipper getInstance() {
        if (instance == null) {
            instance = new Flipper();
        }
        return instance;
    }

    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean running) {
        isRunning = running;
    }

    public int getCredit() {
        return this.credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public AbstractFactory<DisplayText> getDisplayTextFactory() {
        return this.factory;
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


    public void setState(State state) {
        this.state = state;
    }

    public State getState() {return this.state;}

    public void addCredit(){
        credit++;
    }

    public void intro() throws InterruptedException {
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
                userInterface();
                break;
            case 2:
                AbstractFactoryB textB = new AbstractFactoryB();
                this.factory = textB;
                userInterface();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                intro();
                break;
        }
    }

    public void userInterface() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Credits: " + credit + "\nPress 1: Enter Coin \n Press 2:Start \n Press 3: Exit \n Choice: ");
        int input = scanner.nextInt();
        if (input == 1) {
            this.state.insertCoin();
        } else if (input == 2) {
            this.state.pressStart();

        } else if (input == 3) {
            System.out.println("Exiting the program. Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid input");
            userInterface();
        }
    }

    public Command commandRandomizer() {
        ArrayList<Command> commands = createdCommands();
        Random random = new Random();
        int randomNumber = random.nextInt(commands.size());
        return commands.get(randomNumber);
    }

    public void createFlipper() {
        //For a guaranteed Losing Condition
        LoseBallCommand loseBallCommand = new LoseBallCommand(this);
        Outlane outlane = new Outlane(loseBallCommand);

        //evtl. elementID und mit loops kreieren
        Target target1 = new Target(commandRandomizer(), this.mediator);
        Target target2 = new Target(commandRandomizer(), this.mediator);
        Target target3 = new Target(commandRandomizer(), this.mediator);
        Ramp ramp = new Ramp(commandRandomizer(), this.mediator);
        Bumper bumper1 = new Bumper(commandRandomizer());
        Bumper bumper2 = new Bumper(commandRandomizer());
        Hole hole = new Hole(commandRandomizer());
        Slingshot slingshot = new Slingshot(commandRandomizer());
        this.flipperElementCompositum = new FlipperElementCompositum();
        flipperElementCompositum.add(target1);
        flipperElementCompositum.add(target2);
        flipperElementCompositum.add(target3);
        flipperElementCompositum.add(ramp);
        flipperElementCompositum.add(bumper1);
        flipperElementCompositum.add(bumper2);
        flipperElementCompositum.add(hole);
        flipperElementCompositum.add(slingshot);
        flipperElementCompositum.add(outlane);
        mediator.element(flipperElementCompositum.getElements());
    }

    public ArrayList<Command> createdCommands() {
        ArrayList<Command> commands = new ArrayList<Command>();
        LoseBallCommand loseBallCommand = new LoseBallCommand(this);
        Minigame minigame = new Minigame(scoreboard);
        LuckyShot luckyShot = new LuckyShot(scoreboard);
        Flashinglights flash = new Flashinglights();
        FlashinglightsCommandAdapter flashinglightsCommandAdapter = new FlashinglightsCommandAdapter(flash);
        CommandCompositum commandCompositum = new CommandCompositum();
        commandCompositum.addCommand(luckyShot);
        commandCompositum.addCommand(flashinglightsCommandAdapter);
        commands.add(loseBallCommand);
        commands.add(commandCompositum);
        commands.add(minigame);
        return commands;
    }

    public void resetGame() {
        mediator.allTargetsHit();
        getScoreboard().setRoundScore(0);
        getScoreboard().setTotalScore(0);
        setIsRunning(true);
        setBalls(3);
    }
}
