package FlipperElements;

public interface Element {
    void hit();

    void setElementScoreValue(Integer elementScoreValue);

    int getElementScore();

    void setElementHitCount(int elementHitCount);

    int getElementHitCount();

    void setElementStatus();

    void getElementStatus();

    int acceptResetVisitor();

    int acceptScoreVisitor();
}
