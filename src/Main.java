import Command.HitCommand;
import Command.*;
import Compositum.CommandCompositum;
import Compositum.FlipperElementCompositum;
import FlipperElements.Target;
import Mediator.*;

public class Main {
    public static void main(String[] args) {

        TargetMediator mediator = new TargetMediator();
        Target a = new Target(mediator);
        Target b = new Target(mediator);
        FlipperElementCompositum compositum = new FlipperElementCompositum(a,b);
        Command hit = new HitCommand(a);
        Command hitb = new ChangeStateCommand(b);
        Command changeState = new ChangeStateCommand(a);
        CommandCompositum commands = new CommandCompositum();
        mediator.addTarget(compositum.getTargets());
        mediator.mediate(compositum);
        commands.addCommand(hit);
        commands.addCommand(changeState);
        commands.addCommand(hitb);
        b.hit(commands);
        a.hit(commands);
        System.out.println(b.getElementStatus());
        System.out.println(a.getElementStatus());
    }
}