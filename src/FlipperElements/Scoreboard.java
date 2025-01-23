package FlipperElements;

public class Scoreboard {
    private int roundScore;
    private int totalScore;


    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }


    public void addRoundScore(int score) {
        this.roundScore += score;
        addToTotalScore();
    }

    private void addToTotalScore() {
        this.totalScore += this.roundScore;
    }

    public void printRoundScore() {
        System.out.println("Your score this round is: " + this.roundScore);
    }

    public void printTotalScore() {
        System.out.println("Total score is: " + this.totalScore);
    }
}
