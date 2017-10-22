package com.mbans.sandbox.cs.drawingapp;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Rectangle extends DrawableComponent {

    private Point topLeft;
    private Point bottomRight;
    private char symbol;

    public Rectangle(Canvas canvas, Point topleft, Point bottomRight, char symbol) {
        super(canvas);
        this.topLeft = topleft;
        this.bottomRight = bottomRight;
        this.symbol = symbol;
    }

    public void draw() {
        if(getPixels().size() == 1) {
            System.out.println("Different points should be supplied when creating a rectangle");
            return;
        }
        super.draw();
    }

    /**
     * Collect the pixels of the 4 lines that make up the rectangle
     */
    public Set<Pixel> getPixels() {
        Line topLine = new Line(getCanvas(), topLeft, new Point(bottomRight.x, topLeft.y), symbol);
        Line bottomLine = new Line(getCanvas(), new Point(topLeft.x, bottomRight.y), bottomRight, symbol);
        Line leftLine = new Line(getCanvas(), topLeft, bottomLine.getStart(), symbol);
        Line rightLine = new Line(getCanvas(), topLine.getEnd(), bottomLine.getEnd(), symbol);

        Set<Pixel> pixels = new HashSet<Pixel>();
        pixels.addAll(topLine.getPixels());
        pixels.addAll(bottomLine.getPixels());
        pixels.addAll(leftLine.getPixels());
        pixels.addAll(rightLine.getPixels());
        return pixels;
    }
}
