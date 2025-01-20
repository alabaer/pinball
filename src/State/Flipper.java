package State;

import AbstractFactory.*;

import java.util.Scanner;

public class Flipper {
    private static Flipper instance;
    private State state;
    private DisplayText displayText;
    private int credit;
    private int balls = 3;

    public int getCredit() {
        return this.credit;
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

    public void intro() {
        this.setState(this.state);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1: Enter Coin \n Press 2:Start \n Press 3: Exit \n Choice: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                this.state.insertCoin();
                break;
            case 2:
                this.state.pressStart();
                intro();
                break;
            case 3:
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input! Please try Again");
                intro();
                break;
        }
    }

    public void chooseFont() {
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
                DisplayTextA textA = new DisplayTextA();
                this.displayText = textA;
                intro();
                break;
            case 2:
                DisplayTextB textB = new DisplayTextB();
                this.displayText = textB;
                intro();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                chooseFont();
                break;
        }
    }
}
