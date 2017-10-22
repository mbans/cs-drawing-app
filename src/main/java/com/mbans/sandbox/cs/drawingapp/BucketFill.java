package com.mbans.sandbox.cs.drawingapp;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a fill operation that can be applied to a Canvas
 */
public class BucketFill extends DrawableComponent {

    private Point point;
    private char fillSymbol;

    public BucketFill(final Canvas canvas, final Point point, final char fillSymbol) {
        super(canvas);
        this.point = point;
        this.fillSymbol = fillSymbol;
    }

    public Set<Pixel> getPixels() {
        Set<Pixel> pixelsToFill  = new HashSet<Pixel>();
        java.util.List<Point> visited = new ArrayList<Point>();

        //The symbol at the initially specified point
        char symbolToBeFilled = getCanvas().getPixel(point.y, point.x);

        fill(point, symbolToBeFilled, fillSymbol, pixelsToFill, visited);

        return pixelsToFill;
   }

    /**
     * Given a point on a canvas, recusively search and identify the pixels that should be 'filled' in order to
     * replicate functionality of standard 'paint bucket' operation.
     *
     * @param point - starting point for the fill operaiton
     * @param preFillSymbol - the character we are aiming to replace
     * @param fillSymbol - the character we will fill the identified pixels with
     * @param pixelsToFill - pixels that have been identified as needing to be filled
     * @param visitied - pixels previously visited
     */
    private void fill(final Point point, final char preFillSymbol, final char fillSymbol, Set<Pixel> pixelsToFill, java.util.List<Point> visitied) {

        int row = point.y;
        int col = point.x;

        if(visitied.contains(point)) {
            return;
        }

        visitied.add(point);

        //have we already filled this point
        if(pixelsToFill.contains(new Pixel(point,fillSymbol))) {
            return;
        }

        if(getCanvas().isHorizontalPerimeter(row)) {
            return;
        }

        if(getCanvas().isVerticalPerimeter(col)) {
            return;
        }


        char symbolAtPixel = getCanvas().getPixel(row, col);

        //Encountered a different symbol at this point, so we are done.
        if(symbolAtPixel != preFillSymbol) {
            return;
        }

        pixelsToFill.add(new Pixel(new Point(point.x, point.y), fillSymbol));

        //Recusively fill the surrounding points
        fill(new Point(point.x-1, point.y), preFillSymbol, fillSymbol, pixelsToFill, visitied); //left
        fill(new Point(point.x+1, point.y), preFillSymbol, fillSymbol, pixelsToFill, visitied); //right
        fill(new Point(point.x, point.y-1), preFillSymbol, fillSymbol, pixelsToFill, visitied); //below
        fill(new Point(point.x, point.y+1), preFillSymbol, fillSymbol, pixelsToFill, visitied); //above
    }

}
