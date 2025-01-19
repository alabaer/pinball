package Command;

import FlipperElements.Element;

public class ChangeStateCommand implements Command {

    private Element element;

    @Override
    public void execute() {
    element.setElementStatus();
    }
}
