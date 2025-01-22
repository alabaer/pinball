package Visitor;

import Compositum.FlipperElementCompositum;
import FlipperElements.*;

public class Resetvisitor implements Visitor {

    public Resetvisitor() {
    }

    public int visit(Ramp ramp) {
        ramp.setElementHitCount(0);
        ramp.setElementStatus(false);
        return 1;
    }

   public int visit(Hole hole) {
        hole.setElementHitCount(0);
        hole.setElementStatus(true);
        return 1;
    }

    public int visit(Target target) {
        target.setElementHitCount(0);
        target.setElementStatus(true);
        return 1;
    }

    @Override
    public int visit(Outlane outlane) {
        outlane.setElementHitCount(0);
        outlane.setElementStatus(true);
        return 1;
    }

    @Override
    public int visit(FlipperElementCompositum flipperElementCompositum) {
        return 0;
    }

    public int visit(Bumper bumper) {
        bumper.setElementHitCount(0);
        bumper.setElementStatus(true);
        return 1;
    }
    public int visit (Slingshot slingshot){
        slingshot.setElementHitCount(0);
        slingshot.setElementStatus(true);
        return 1;
    }

}
