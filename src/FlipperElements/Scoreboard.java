package FlipperElements;

public class Scoreboard {
    private int score;

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void printScore() {
        System.out.println("Your score is: " + this.score);
    }
}
