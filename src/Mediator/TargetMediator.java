package Mediator;

import FlipperElements.Element;
import FlipperElements.Ramp;
import FlipperElements.Target;

import java.util.ArrayList;

public class TargetMediator implements Mediator {
    private ArrayList<Element> elements;

    public TargetMediator() {
    }

    public void element(ArrayList<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void mediate(Element sender) {
        if (allTargetsHit()) {
            System.out.println("All targets hit! Activating targets and ramp.");
            for (Element element : elements) {
                if (element instanceof Target) {
                    element.setElementStatus(true);
                    System.out.println("Activating target.");
                }
                if (element instanceof Ramp) {
                    element.setElementStatus(true);
                    System.out.println("Activating ramp.");
                }
            }
        } else {
            System.out.println("Not all targets are hit yet.");
        }
    }

    public boolean allTargetsHit() {
        for (Element element : elements) {
            if (element instanceof Target && element.getElementStatus()) {
                return false;
            }
        }
        return true;
    }
}
