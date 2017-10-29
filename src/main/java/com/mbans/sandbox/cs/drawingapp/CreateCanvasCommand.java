package com.mbans.sandbox.cs.drawingapp;

import static java.lang.Integer.parseInt;

/**
 * Created by lumarmacy on 29/10/2017.
 */
public class CreateCanvasCommand extends Command {

    @Override
    public Canvas execute(Canvas canvas) {
        int width = parseInt(getParameters().get(0));
        int height = parseInt(getParameters().get(1));
        return new Canvas(width, height);
    }
}
