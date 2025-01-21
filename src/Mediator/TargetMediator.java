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
            System.out.println("Es wurden alle Targets getroffen die Rampe fährt herunter und alle Targets sind wieder aktiv!");
            for (Element element : elements) {
                if (element instanceof Target) {
                    element.setElementStatus(true);
                }
            }
            for (Element element : elements) {
                if (element instanceof Ramp) {
                    element.setElementStatus(true);
                }
            }
        }
    }

    private boolean allTargetsHit() {
        for (Element element : elements) {
            if (element instanceof Target && element.getElementStatus()) {
                return false;
            }
        }
        return true;
    }
}


