package AbstractFactory;

public class DisplayTextB implements DisplayText {
    @Override
    public Object displayText(String message) {
        return switch (message.toLowerCase()) {
            case "coindrop" -> new CoindropB();
            case "gameover" -> new GameOverB();
            case "loseball" -> new LoseBallB();
            case "nocredit" -> new NoCreditStateB();
            default -> {
                System.out.println("Typo");
                yield null;
            }
        };
    }
}
