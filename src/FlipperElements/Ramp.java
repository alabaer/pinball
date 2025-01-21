package FlipperElements;

import Command.Command;
import Mediator.*;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

public class Ramp implements Element {
    private final Command command;
    private final int elementScore = 250;
    public int hitCount = 0;
    private Mediator mediator;
    private boolean isActive = false;

    public Ramp(Command command, TargetMediator mediator) {
        this.command = command;
        this.mediator = mediator;
    }

    @Override
    public void hit() throws InterruptedException {
        if (isActive) {
            System.out.println("Ramp hit");
            hitCount++;
            command.execute();
        }
        System.out.println("Target not active");
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
    public int getScore() {
        return this.elementScore * this.hitCount;
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
