package Command;

import FlipperElements.Scoreboard;

import java.util.Random;
import java.util.Scanner;

public class Minigame implements Command {
    private final Scoreboard scoreboard;

    public Minigame(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public void execute() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1; // Gibt eine Zahl zwischen 1 und 3 zurück
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a number between 1 and 3: ");
        int userGuess = scanner.nextInt();
        if (userGuess < 1 || userGuess > 3) {
            System.out.println("Invalid Option! Only numbers between 1 and 3 are allowed.");
            return;
        }
        if (userGuess == randomNumber) {
            System.out.println("Richtig geraten! Die zufällige Zahl war " + randomNumber + ".");
            scoreboard.addScore(200);
        } else {
            System.out.println("Falsch geraten! Die zufällige Zahl war " + randomNumber + ".");
        }
    }
}
