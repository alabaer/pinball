import Command.HitCommand;
import Command.*;
import Compositum.FlipperElementCompositum;
import FlipperElements.Bumper;
import FlipperElements.Element;
import FlipperElements.Ramp;
import FlipperElements.Target;
import Mediator.*;
import Visitor.Pointsvisitor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        TargetMediator mediator = new TargetMediator();
        Target a = new Target(mediator);
        Target b = new Target(mediator);
        Ramp c = new Ramp(mediator);
        Bumper bumper = new Bumper();
        Pointsvisitor visitor = new Pointsvisitor();
        FlipperElementCompositum compositum = new FlipperElementCompositum(a, b, c);
        ArrayList<Element> liste = new ArrayList<Element>();
        Command hitbumer = new HitCommand(bumper);
        Command hita = new HitCommand(a);
        Command hitb = new HitCommand(b);
        Command hitc = new HitCommand(c);
        Command ahit = new ChangeStateCommand(a);
        Command bhit = new ChangeStateCommand(b);
        mediator.addTargets(compositum.getTargets());
        a.hit(hita);
        b.hit(hitb);
        a.hit(ahit);
        b.hit(bhit);
        bumper.hit(hitbumer);
        liste.add(compositum);
        liste.add(bumper);
        System.out.println(a.getElementStatus());
        System.out.println(b.getElementStatus());
        c.hit(hitc);
        for (Element e : liste) {
            sum += e.acceptScoreVisitor(visitor);
        }
        System.out.println(a.getElementStatus());
        System.out.println(b.getElementStatus());
        System.out.println(sum);
    }
}