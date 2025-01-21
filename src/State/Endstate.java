package State;

import AbstractFactory.DisplayText;
import FlipperElements.Element;
import Visitor.Resetvisitor;

public class Endstate extends State {
    private Flipper flipper;

    public Endstate(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        System.out.println("Nothing happens");
    }

    @Override
    public void pressStart() throws InterruptedException {
        if (flipper.getCredit() > 0) {
            Ready ready = new Ready(flipper);
            flipper.setState(ready);
            flipper.text();
        } else {
            System.out.println("Not enough credits. Insert a coin first.");
            Resetvisitor resetvisitor = new Resetvisitor();
            for(Element element : flipper.getFlipperElementCompositum().getElements()) {
            element.acceptResetVisitor(resetvisitor);
            }
            flipper.setState(new NoCredit(flipper));
            flipper.text();
        }
    }
}
