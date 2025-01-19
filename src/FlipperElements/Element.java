package FlipperElements;
import Command.*;
public interface Element {
    void hit(Command command);

    int getElementScore();

    void setElementHitCount(int elementHitCount);

    int getElementHitCount();

    void setElementStatus(Boolean isHit);

    boolean getElementStatus();

    void acceptResetVisitor();

    void acceptScoreVisitor();
}
