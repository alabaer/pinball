package Command;

import FlipperElements.Element;

public class HitCommand implements Command {
    Element element;


    @Override
    public void execute() {
        element.setElementHitCount(element.getElementHitCount() + 1);
    }
}
