package Compositum;
import FlipperElements.Element;
import FlipperElements.Ramp;
import FlipperElements.Target;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

import java.util.ArrayList;
import java.util.Random;

public class FlipperElementCompositum implements Element {
    private Target target1;
    private Target target2;
    private Target target3;
    private Ramp ramp;
    private ArrayList<Element> elements;

    public FlipperElementCompositum() {
        elements = new ArrayList<>();
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void hit() throws InterruptedException {
        Random random = new Random();
        int randomNumber = random.nextInt(elements.size());
        elements.get(randomNumber).hit();
    }

    @Override
    public int getElementHitCount() {
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
    public int acceptResetVisitor(Resetvisitor resetvisitor) {
        for (Element element : elements) {
            element.acceptResetVisitor(resetvisitor);
        }
        return 0;
    }

    @Override
    public int acceptScoreVisitor(Pointsvisitor pointsvisitor) {
        return pointsvisitor.visit(this);
    }
}
