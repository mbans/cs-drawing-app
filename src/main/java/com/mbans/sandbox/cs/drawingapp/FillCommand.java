package com.mbans.sandbox.cs.drawingapp;

import java.awt.*;

import static java.lang.Integer.parseInt;

/**
 * Created by lumarmacy on 29/10/2017.
 */
public class FillCommand extends Command{

    @Override
    public Canvas execute(Canvas canvas) {
        if(isCanvasNull(canvas)) {
            return canvas;
        }

        Point start = new Point(parseInt(getParameters().get(0)), parseInt(getParameters().get(1)));
        char fillSymbol = getParameters().get(2).charAt(0);
        new BucketFill(canvas, start, fillSymbol).draw();
        return canvas;
    }
}
