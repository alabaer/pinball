package Mediator;

import Compositum.FlipperElementCompositum;
import FlipperElements.Element;
import FlipperElements.Target;

import java.util.ArrayList;
import java.util.List;

public class TargetMediator implements Mediator {
    private ArrayList<Target> targets;

    public TargetMediator() {
    }

    public void addTarget(ArrayList<Target> targets) {
        this.targets = targets;
    }

    @Override
    public void mediate(Element sender) {
        System.out.println("Es wurde ein Target getroffen.");
        boolean allInactive = true;
        for (Target target : targets) {
            if (target.getElementStatus()) {
                allInactive = false;
                break;
            }
        }
        if (allInactive) {
            System.out.println("Es wurden alle Targets getroffen und somit sind alle wieder aktiv!");
            for (Target target : targets) {
                target.setElementStatus(false);
            }
        }
    }

    public void setTargets(Target target) {
        targets.add(target);
    }
}

