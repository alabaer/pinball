package FlipperElements;

public class Scoreboard {
    private int roundScore;
    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getRoundScore() {
        return roundScore;
    }

    public void addScore(int score) {
        this.roundScore += score;
        addToTotalScore();
    }

    private void addToTotalScore() {
        this.totalScore += this.roundScore;
    }

    public void printroundScore() {
        System.out.println("Your score this round is: " + this.roundScore);
    }

    public void printTotalScore() {
        System.out.println("Total score is: " + this.totalScore);
    }
}
