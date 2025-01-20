package FlipperElements;

import Command.Command;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

public class Slingshot implements Element {
    private int elementScore = 50;
    public int hitCount = 0;
    private boolean isActive = true;

    @Override
    public void hit(Command command) {
        command.execute();
    }

    @Override
    public int getElementScore() {
        return this.elementScore;
    }

    @Override
    public void setElementHitCount(int elementHitCount) {
        this.hitCount = elementHitCount;
    }

    @Override
    public int getElementHitCount() {
        return this.hitCount;
    }

    @Override
    public void setElementStatus(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean getElementStatus() {
        return this.isActive;
    }

    @Override
    public void acceptResetVisitor(Resetvisitor resetvisitor) {
        resetvisitor.visit(this);
    }

    @Override
    public void acceptScoreVisitor(Pointsvisitor pointsvisitor) {
        pointsvisitor.visit(this);
    }
}
