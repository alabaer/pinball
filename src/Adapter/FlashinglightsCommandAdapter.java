package Adapter;

import Command.Command;

public class FlashinglightsCommandAdapter implements Command {
    private final Flashinglights flashinglights;

    public FlashinglightsCommandAdapter(Flashinglights flashinglights) {
        this.flashinglights = flashinglights;
    }

    @Override
    public void execute() throws InterruptedException {
        flashinglights.lightsFlashing();
        Thread.sleep(1000);
    }
}
