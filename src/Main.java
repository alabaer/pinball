import AbstractFactory.*;
import State.Flipper;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Welcome welcome = new Welcome();
        welcome.create();
        Thread.sleep(3000);
        Flipper flipper = Flipper.getInstance();
        flipper.chooseFont();
    }


}