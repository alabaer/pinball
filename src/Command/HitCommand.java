package Command;

import FlipperElements.Element;

public class HitCommand implements Command {
    Element element;

    public HitCommand(Element element) {
        this.element = element;
    }

    @Override
    public void execute() {
        if(element.getElementStatus()) {
            element.setElementHitCount(element.getElementHitCount() + 1);
            System.out.println(element.getElementHitCount());
        }
    }
}
