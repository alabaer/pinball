package Compositum;

import Command.Command;
import FlipperElements.Element;
import FlipperElements.Target;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

import java.util.ArrayList;
import java.util.List;

public class FlipperElementCompositum implements Element {
    private Target target1;
    private Target target2;
    private List<Target> targets;

    public FlipperElementCompositum(Target target1, Target target2) {
        targets = new ArrayList<Target>();
        this.target1 = target1;
        this.target2 = target2;
        targets.add(target1);
        targets.add(target2);
    }

    public ArrayList<Target> getTargets() {
        return (ArrayList<Target>) this.targets;
    }

    @Override
    public void hit(Command command) {

    }

    @Override
    public int getElementScore() {
        return 0;
    }

    @Override
    public void setElementHitCount(int elementHitCount) {

    }

    @Override
    public int getElementHitCount() {
        return 0;
    }

    @Override
    public void setElementStatus(Boolean isHit) {

    }

    @Override
    public boolean getElementStatus() {
        return false;
    }

    @Override
    public void acceptResetVisitor(Resetvisitor resetvisitor) {
        resetvisitor.visit(this);
    }

    @Override
    public void acceptScoreVisitor(Pointsvisitor pointsvisitor) {

    }
}
