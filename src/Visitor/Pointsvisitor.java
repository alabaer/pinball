package Visitor;

import Compositum.FlipperElementCompositum;
import FlipperElements.*;

public class Pointsvisitor {
    public int visit(Bumper bumper) {
        return bumper.getScore();
    }

    public int visit(Hole hole) {
        return hole.getScore();
    }

    public int visit(Ramp ramp) {
        return ramp.getScore();
    }

    public int visit(Slingshot slingshot) {
        return slingshot.getScore();
    }

    public int visit(Target target) {
        return target.getScore();
    }
    public int visit(FlipperElementCompositum flipperElementCompositum) {
        return flipperElementCompositum.getScore();
    }
}
