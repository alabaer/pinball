package FlipperElements;

import Command.Command;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

public class Outlane implements Element {
    private final int elementScore = -50;
    private final Command command;
    public int hitCount = 0;
    private boolean isActive = true;

    public Outlane(Command command) {
        this.command = command;
    }

    @Override
    public void hit() throws InterruptedException {
        System.out.println("Outlane hit! -50 Points!");
        hitCount++;
        command.execute();
    }

    @Override
    public int getElementHitCount() {
        return this.hitCount;
    }

    @Override
    public void setElementHitCount(int elementHitCount) {
        this.hitCount = elementHitCount;
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
    public int getScore() {
        return this.elementScore*getElementHitCount();
    }

    @Override
    public int acceptResetVisitor(Resetvisitor resetvisitor) {
        return resetvisitor.visit(this);
    }

    @Override
    public int acceptScoreVisitor(Pointsvisitor pointsvisitor) {
        return pointsvisitor.visit(this);
    }
}
