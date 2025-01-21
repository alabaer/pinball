package State;

public abstract class State {
    public abstract void insertCoin() throws InterruptedException;
    public abstract void pressStart() throws InterruptedException;
}
