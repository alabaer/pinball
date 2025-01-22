package FlipperElements;

import Command.Command;
import Mediator.TargetMediator;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

public class Target implements Element {
    private final Command command;
    private int elementScore = 75;
    public int hitCount = 0;
    private boolean isActive = true;
    private TargetMediator mediator;

    public Target(Command command, TargetMediator mediator) {
        this.command = command;
        this.mediator = mediator;;
    }

    @Override
    public void hit() throws InterruptedException {
        if(this.isActive) {
            System.out.println("Target hit");
            this.hitCount++;
            this.isActive = false;
            this.mediator.mediate(this);
            command.execute();
        }
        System.out.println("Target inactive");
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
    public int acceptResetVisitor(Resetvisitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public int acceptScoreVisitor(Pointsvisitor pointsvisitor) {
       return pointsvisitor.visit(this);
    }

}
