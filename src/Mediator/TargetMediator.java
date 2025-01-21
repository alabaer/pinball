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
        // Check if all targets are hit
        if (allTargetsHit()) {
            System.out.println("All targets hit! Activating targets and ramp.");
            // Activate all targets and ramp
            for (Element element : elements) {
                if (element instanceof Target) {
                    element.setElementStatus(true); // Reset the target
                    System.out.println("Activating target.");
                }
                if (element instanceof Ramp) {
                    element.setElementStatus(true); // Reset the ramp
                    System.out.println("Activating ramp.");
                }
            }
        } else {
            // If not all targets are hit, only reset the specific target
            System.out.println("Not all targets are hit yet.");
        }
    }

    private boolean allTargetsHit() {
        // Check if all targets are hit (inactive state means hit)
        for (Element element : elements) {
            if (element instanceof Target && element.getElementStatus()) {
                return false; // If any target is still active, return false
            }
        }
        return true; // All targets are hit
    }
}
