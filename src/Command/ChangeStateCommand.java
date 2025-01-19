package Command;

import FlipperElements.Element;

public class ChangeStateCommand implements Command {

    private Element element;

    public ChangeStateCommand(Element element) {
        this.element = element;
    }

    @Override
    public void execute() {
        element.setElementStatus(true);
    }
}
