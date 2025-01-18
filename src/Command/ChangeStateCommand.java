package Command;

import FlipperElements.Elements;

public class ChangeStateCommand implements Command {

    private Elements elements;

    @Override
    public void execute() {
    elements.setElementStatus();
    }
}
