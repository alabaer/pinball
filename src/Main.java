import AbstractFactory.Welcome;
import Adapter.Flashinglights;
import Adapter.FlashinglightsCommandAdapter;
import Command.HitCommand;
import Command.*;
import Compositum.CommandCompositum;
import Compositum.FlipperElementCompositum;
import FlipperElements.Ramp;
import FlipperElements.Target;
import Mediator.*;

public class Main {
    public static void main(String[] args) {

        /*TargetMediator mediator = new TargetMediator();
        Target a = new Target(mediator);
        Target b = new Target(mediator);
        Ramp c = new Ramp(mediator);
        FlipperElementCompositum compositum = new FlipperElementCompositum(a, b, c);
        Command hita = new HitCommand(a);
        Command hitb = new HitCommand(b);
        Command hitc = new HitCommand(c);
        Command changeStateb = new ChangeStateCommand(b);
        Command changeStatea = new ChangeStateCommand(a);
        CommandCompositum commandsa = new CommandCompositum();
        CommandCompositum commandsb = new CommandCompositum();
        Flashinglights flash = new Flashinglights();
        Command flashing = new FlashinglightsCommandAdapter(flash);
        mediator.addTargets(compositum.getTargets());
        commandsa.addCommand(hita);
        commandsa.addCommand(changeStatea);
        commandsb.addCommand(changeStateb);
        commandsb.addCommand(hitb);
        commandsb.addCommand(flashing);
        System.out.println(b.getElementStatus());
        b.hit(commandsb);
        c.hit(hitc);
        System.out.println(b.getElementStatus());
        b.hit(commandsb);
        System.out.println(a.getElementStatus());
        a.hit(commandsa);
        System.out.println(a.getElementStatus());

        mediator.mediate(compositum);
        System.out.println(b.getElementStatus());
        System.out.println(a.getElementStatus());
        b.hit(commandsb);
        c.hit(hitc);
        System.out.println(c.getElementStatus());*/
        Welcome welcome = new Welcome();
        welcome.create();
    }
}