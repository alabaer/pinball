package FlipperElements;

import Command.*;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

public interface Element {

    void hit() throws InterruptedException;

    int getElementHitCount();

    void setElementHitCount(int elementHitCount);

    void setElementStatus(Boolean isActive);

    boolean getElementStatus();

    int getScore();

    int acceptResetVisitor(Resetvisitor resetvisitor);

    int acceptScoreVisitor(Pointsvisitor pointsvisitor);
}
