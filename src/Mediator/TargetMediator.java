package Mediator;

import FlipperElements.Element;
import FlipperElements.Target;

import java.util.ArrayList;

public class TargetMediator implements Mediator {
    private ArrayList<Target> targets;

    public TargetMediator() {
    }

    public void addTargets(ArrayList<Target> targets) {
        this.targets = targets;
    }

    @Override
    public void mediate(Element sender) {
        if (allTargetsHit()) {
            System.out.println("Es wurden alle Targets getroffen und somit sind alle wieder aktiv!");
            for (Target target : targets) {
                target.setElementStatus(false);
            }
        }
    }
    private boolean allTargetsHit(){
        return targets.get(0).getElementStatus() && targets.get(1).getElementStatus();
    }
}

