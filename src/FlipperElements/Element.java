package FlipperElements;

import Command.*;
import Visitor.Pointsvisitor;
import Visitor.Resetvisitor;

public interface Element {
    void hit(Command command);

    int getElementScore();

    void setElementHitCount(int elementHitCount);

    int getElementHitCount();

    void setElementStatus(Boolean isActive);

    boolean getElementStatus();

    void acceptResetVisitor(Resetvisitor resetvisitor);

    void acceptScoreVisitor(Pointsvisitor pointsvisitor);
}
