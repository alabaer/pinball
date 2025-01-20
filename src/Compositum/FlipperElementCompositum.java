package Compositum;

import Command.Command;
import FlipperElements.Element;
import FlipperElements.Ramp;
import FlipperElements.Target;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

import java.util.ArrayList;

public class FlipperElementCompositum implements Element {
    private Target target1;
    private Target target2;
    private Ramp ramp;
    private ArrayList<Element> elements;
    private boolean isActive = true;

    public FlipperElementCompositum(Target target1, Target target2, Ramp ramp) {
        elements = new ArrayList<>();
        this.target1 = target1;
        this.target2 = target2;
        elements.add(target1);
        elements.add(target2);
        elements.add(ramp);
    }

    public ArrayList<Element> getTargets() {
        return this.elements;
    }

    public void add (Element element) {
        elements.add(element);
    }

    @Override
    public void hit(Command command) {

    }

    @Override
    public int getElementHitCount() {
        return 0;
    }

    @Override
    public void setElementHitCount(int elementHitCount) {

    }

    @Override
    public void setElementStatus(Boolean isActive) {

    }

    @Override
    public boolean getElementStatus() {
        return false;
    }

    @Override
    public int getScore() {
        int score = 0;
        for (Element element : elements) {
            score += element.getScore();
        }
        return score;
    }

    @Override
    public void acceptResetVisitor(Resetvisitor resetvisitor) {
    }

    @Override
    public int acceptScoreVisitor(Pointsvisitor pointsvisitor) {
return pointsvisitor.visit(this);
    }
}
