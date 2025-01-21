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
    private Target target3;
    private Ramp ramp;
    private ArrayList<Element> elements;
    private boolean isActive = true;

    public FlipperElementCompositum(Target target1, Target target2, Target target3, Ramp ramp) {
        elements = new ArrayList<>();
        this.target1 = target1;
        this.target2 = target2;
        this.target3 = target3;
        elements.add(target1);
        elements.add(target2);
        elements.add(ramp);
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void hit() {
        //leer weil nutzlos
    }

    @Override
    public int getElementHitCount() {
        //0 weil nutzlos
        return 0;
    }

    @Override
    public void setElementHitCount(int elementHitCount) {
        for (Element element : elements) {
            element.setElementHitCount(elementHitCount);
        }
    }

    @Override
    public void setElementStatus(Boolean isActive) {
        for (Element element : elements) {
            element.setElementStatus(isActive);
        }
    }

    @Override
    public boolean getElementStatus() {
        //nutzlos
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
        for (Element element : elements) {
            element.acceptResetVisitor(resetvisitor);
        }
    }

    @Override
    public int acceptScoreVisitor(Pointsvisitor pointsvisitor) {
        return pointsvisitor.visit(this);
    }
}
