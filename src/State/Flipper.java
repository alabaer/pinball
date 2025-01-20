package State;

public class Flipper {
    private static Flipper instance;
    private State state;
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

    public static synchronized Flipper Instance() {
        if (instance == null) {
            instance = new Flipper();
        }
        return instance;
    }

    public void setState(State state) {
        this.state = state;
    }
}
