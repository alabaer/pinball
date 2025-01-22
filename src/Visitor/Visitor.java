package Visitor;

import Compositum.FlipperElementCompositum;
import FlipperElements.*;

public interface Visitor {
    int visit(Bumper bumper);
    int visit (Hole hole);
    int visit (Ramp ramp);
    int visit (Slingshot slingshot);
    int visit (Target target);
    int visit (Outlane outlane);
    int visit (FlipperElementCompositum flipperElementCompositum);


}
