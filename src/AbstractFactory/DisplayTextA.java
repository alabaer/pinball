package AbstractFactory;

public class DisplayTextA implements DisplayText {
    @Override
    public Object displayText(String message) {
        return switch (message.toLowerCase()) {
            case "coindrop" -> new CoindropA();
            case "gameover" -> new GameOverA();
            case "loseball" -> new LoseBallA();
            case "nocredit" -> new NoCreditStateA();
            default -> {
                System.out.println("Typo");
                yield null;
            }
        };
    }
}
