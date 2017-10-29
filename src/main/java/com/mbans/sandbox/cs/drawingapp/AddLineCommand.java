package com.mbans.sandbox.cs.drawingapp;

import java.awt.*;

import static java.lang.Integer.parseInt;

/**
 * Created by lumarmacy on 29/10/2017.
 */
public class AddLineCommand extends Command {

    @Override
    public Canvas execute(Canvas canvas) {
        if(isCanvasNull(canvas)) {
            return canvas;
        }

        Point start = new Point(parseInt(getParameters().get(0)), parseInt(getParameters().get(1)));
        Point end = new Point(parseInt(getParameters().get(2)), parseInt(getParameters().get(3)));
        new Line(canvas, start, end, 'x').draw();
        return canvas;
    }
}
