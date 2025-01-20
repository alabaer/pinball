package Visitor;

import Compositum.FlipperElementCompositum;
import FlipperElements.*;

public class Resetvisitor {

    public Resetvisitor() {
    }

    public void visit(Ramp ramp) {
        ramp.setElementHitCount(0);
        ramp.setElementStatus(false);
    }

   public void visit(Hole hole) {
        hole.setElementHitCount(0);
        hole.setElementStatus(true);
    }

    public void visit(Target target) {
        target.setElementHitCount(0);
        target.setElementStatus(true);
    }

    public void visit(Bumper bumper) {
        bumper.setElementHitCount(0);
        bumper.setElementStatus(true);
    }
    public void visit (Slingshot slingshot){
        slingshot.setElementHitCount(0);
        slingshot.setElementStatus(true);
    }
    public void visit (FlipperElementCompositum flipperElementCompositum){
        flipperElementCompositum.setElementHitCount(0);
    }
}
