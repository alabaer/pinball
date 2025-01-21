package AbstractFactory;

public class AbstractFactoryB implements AbstractFactory<DisplayText> {
    @Override
    public DisplayText displayText(String message) {
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
