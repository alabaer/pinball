package Visitor;

import Compositum.FlipperElementCompositum;
import FlipperElements.*;

public class Pointsvisitor implements Visitor {
    @Override
    public int visit(Bumper bumper) {
        return bumper.getScore();
    }

    @Override
    public int visit(Hole hole) {
        return hole.getScore();
    }

    @Override
    public int visit(Ramp ramp) {
        return ramp.getScore();
    }

    @Override
    public int visit(Slingshot slingshot) {
        return slingshot.getScore();
    }

    @Override
    public int visit(Target target) {
        return target.getScore();
    }

    @Override
    public int visit(Outlane outlane) {
        return outlane.getScore();
    }

    @Override
    public int visit(FlipperElementCompositum flipperElementCompositum) {
        return flipperElementCompositum.getScore();
    }
}
