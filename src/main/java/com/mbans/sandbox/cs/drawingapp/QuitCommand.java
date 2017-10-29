package com.mbans.sandbox.cs.drawingapp;

/**
 * Created by lumarmacy on 29/10/2017.
 */
public class QuitCommand extends Command {

    @Override
    public Canvas execute(Canvas canvas) {
        System.out.println("Quitting application");
        System.exit(0);
        return null;
    }
}
