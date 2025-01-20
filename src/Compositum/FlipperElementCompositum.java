package Compositum;

import Command.Command;
import FlipperElements.Element;
import FlipperElements.Ramp;
import FlipperElements.Target;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

import java.util.ArrayList;
import java.util.List;

public class FlipperElementCompositum implements Element {
    private Target target1;
    private Target target2;
    private Ramp ramp;
    private List<Element> elements;

    public FlipperElementCompositum(Target target1, Target target2, Ramp ramp) {
        elements = new ArrayList<Element>();
        this.target1 = target1;
        this.target2 = target2;
        elements.add(target1);
        elements.add(target2);
        elements.add(ramp);
    }

    public ArrayList<Element> getTargets() {
        return (ArrayList<Element>) this.elements;
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
    public void setElementStatus(Boolean isActive) {

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
