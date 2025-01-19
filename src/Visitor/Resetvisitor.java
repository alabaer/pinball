package Visitor;

import Compositum.FlipperElementCompositum;
import FlipperElements.*;

public class Resetvisitor {

    public Resetvisitor() {
    }

    public void visit(Ramp ramp) {
        ramp.setElementHitCount(0);
    }

   public void visit(Hole hole) {
        hole.setElementHitCount(0);
    }

    public void visit(Target target) {
        target.setElementHitCount(0);
    }

    public void visit(Bumper bumper) {
        bumper.setElementHitCount(0);
    }
    public void visit (Slingshot slingshot){
        slingshot.setElementHitCount(0);
    }
    public void visit (FlipperElementCompositum flipperElementCompositum){
        flipperElementCompositum.setElementHitCount(0);
    }
}
