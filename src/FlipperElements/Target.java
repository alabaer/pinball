package FlipperElements;

import Command.Command;
import Mediator.TargetMediator;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

public class Target implements Element {
    private int elementScore = 50;
    public int hitCount = 0;
    private boolean isActive = true;
    private TargetMediator mediator;

    public Target(TargetMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void hit(Command command) {
        command.execute();
        mediator.mediate(this);

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
    public void acceptResetVisitor(Resetvisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int acceptScoreVisitor(Pointsvisitor pointsvisitor) {
       return pointsvisitor.visit(this);
    }

}
