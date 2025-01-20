package Mediator;

import FlipperElements.Element;
import FlipperElements.Target;
import java.util.ArrayList;

public class TargetMediator implements Mediator {
    private ArrayList<Element> elements;

    public TargetMediator() {
    }

    public void addTargets(ArrayList<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void mediate(Element sender) {
        if (allTargetsHit()) {
            System.out.println("Es wurden alle Targets getroffen die Rampe fährt herunter und alle Targets sind wieder aktiv!");
            for (Element target : elements) {
                if (target instanceof Target) {
                    target.setElementStatus(true);
                }
            }
            elements.get(2).setElementStatus(true);
        }
    }

    private boolean allTargetsHit() {
        return !elements.get(0).getElementStatus() && !elements.get(1).getElementStatus();
    }
}

