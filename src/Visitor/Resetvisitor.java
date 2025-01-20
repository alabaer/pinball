package Visitor;

import Compositum.FlipperElementCompositum;
import FlipperElements.*;

public class Resetvisitor implements Visitor {

    public Resetvisitor() {
    }

    public int visit(Ramp ramp) {
        ramp.setElementHitCount(0);
        ramp.setElementStatus(false);
        //1 Rampe
        return 1;
    }

   public int visit(Hole hole) {
        hole.setElementHitCount(0);
        hole.setElementStatus(true);
        //1 Hole
        return 1;
    }

    public int visit(Target target) {
        target.setElementHitCount(0);
        target.setElementStatus(true);
        //3 Targets
        return 3;
    }

    @Override
    public int visit(FlipperElementCompositum flipperElementCompositum) {
        flipperElementCompositum.setElementHitCount(0);
        flipperElementCompositum.setElementStatus(true);
        //wird ignoriert
        return 0;
    }

    public int visit(Bumper bumper) {
        bumper.setElementHitCount(0);
        bumper.setElementStatus(true);
        //2 Bumper
        return 2;
    }
    public int visit (Slingshot slingshot){
        slingshot.setElementHitCount(0);
        slingshot.setElementStatus(true);
        //1 Slingshot
        return 1;
    }
}
