package com.mbans.sandbox.cs.drawingapp;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Line extends DrawableComponent {

    private Type type;
    private Point start;
    private Point end;
    private char symbol;

    public Line(Canvas canvas, Point start, Point end, char symbol) {
        super(canvas);
        this.start = start;
        this.end = end;
        this.symbol = symbol;
        this.type = getType();
    }

    public Set<Pixel> getPixels() {
        Set<Pixel> pixels = new HashSet<Pixel>();
        if(this.type==Type.Horizontal) {

            //Start at the smallest point on x-axis first
            for(int x = min(start.x, end.x); x < max(start.x, end.x)+1; x++) {
                pixels.add(new Pixel(new Point(x, start.y), symbol));
            }
        }
        else if (this.type==Type.Vertical) {

            //Start at smallest point on y-axis first
            for(int y = min(start.y, end.y); y < max(start.y, end.y)+1; y++) {
                pixels.add(new Pixel(new Point(start.x, y), symbol));
            }
        }
        return pixels;
    }

    @Override
    public void draw() {
        //If we don't have a horizontal or vertical line then don't draw
        if(type == null) {
            System.out.println("Invalid co-ordinates, only horizontal and vertical lines supported.");
            return;
        }
        super.draw();
    }

    private Type getType() {
        //if x-axis is same then must be vertical line
        if(start.x == end.x) {
            return Type.Vertical;
        }
        else if (start.y == end.y) {
            return Type.Horizontal;
        }
        else {
            return null;
        }
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public enum Type {
        Horizontal,
        Vertical;
    }

}
