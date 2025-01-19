package Visitor;

import FlipperElements.*;

public class Pointsvisitor {
    public int visit(Bumper bumper) {
        return bumper.getElementHitCount() * bumper.getElementScore();
    }

    public int visit(Hole hole) {
        return hole.getElementHitCount() * hole.getElementScore();
    }

    public int visit(Ramp ramp) {
        return ramp.getElementHitCount() * ramp.getElementScore();
    }

    public int visit(Slingshot slingshot) {
        return slingshot.getElementHitCount() * slingshot.getElementScore();
    }

    public int visit(Target target) {
        return target.getElementHitCount() * target.getElementScore();
    }

}
