package Command;

import FlipperElements.Elements;

public class HitCommand implements Command {
    Elements elements;


    @Override
    public void execute() {
        elements.setElementHitCount(elements.getElementHitCount() + 1);
    }
}
