package Command;

import FlipperElements.Scoreboard;

public class LuckyShot implements Command {
    private final Scoreboard scoreboard;

    public LuckyShot(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    @Override
    public void execute() throws InterruptedException {
        System.out.println("Lucky Shot!");
        scoreboard.addScore(25);
        Thread.sleep(1000);
    }
}
