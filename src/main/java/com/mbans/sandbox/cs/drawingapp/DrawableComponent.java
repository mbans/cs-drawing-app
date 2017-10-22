package com.mbans.sandbox.cs.drawingapp;


import java.util.Set;

/**
 * Super class for 'components' that can be drawn onto a canvas
 */
public abstract class DrawableComponent {

    private Canvas canvas;

    public DrawableComponent(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     * Update canvas with pixels relating to this component
     * and draw the updated canvas
     */
    public void draw() {
        boolean truncated = false;
        for(Pixel pixel : this.getPixels()) {
            int row = pixel.getPoint().y;
            int col = pixel.getPoint().x;

            //Only update if the point is within the boundary of the canvas
            if(row > 0 && row <= canvas.getHeight() &&
               col > 0 && col <= canvas.getWidth()) {
                canvas.update(row, col, pixel.getSymbol());
            }
            else {
                truncated = true;
            }

        }

        //Register this component with the canvas
        this.canvas.addAmendment(this);

        //Draw the canvas
        this.canvas.draw();
    }

    /**
     * The pixels that this component consists of
     */
    public abstract Set<Pixel> getPixels();

    public Canvas getCanvas() {
        return this.canvas;
    }
}
