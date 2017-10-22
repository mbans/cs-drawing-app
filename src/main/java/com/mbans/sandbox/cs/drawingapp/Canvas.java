package com.mbans.sandbox.cs.drawingapp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Canvas {

    private int width;
    private int height;
    private final static char horizPerimiter = '-';
    private final static char vertPerimieter = '|';

    private char[][] pixels;

    private List<DrawableComponent> amendments = new ArrayList();

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new char[height+2][width+2];
        setCanvasPerimeter();
        draw();
    }

    /**
     * Draw the canvas
     */
    public void draw() {
        StringBuilder sb = new StringBuilder();

        for(int row=0; row<height+2; row++) {
            buildRowContent(row,sb);
        }

        System.out.println(sb);
    }

    public boolean isHorizontalPerimeter(int rowNum) {
        return rowNum == 0 || rowNum == height + 1;
    }

    public boolean isVerticalPerimeter(int colNum) {
        return colNum == 0|| colNum == width + 1;
    }

    public char getPixel(int row, int col) {
        return pixels[row][col];
    }

    public void update(int row, int col, char symbol) {
        this.pixels[row][col] = symbol;
    }

    public void addAmendment(DrawableComponent amendment) {
        this.amendments.add(amendment);
    }

    /**
     * Determine if this point exists on the canvas
     * @param point
     * @return
     */
    public boolean isValidPoint(Point point) {
        int row = point.y;
        int col = point.x;

        if (row <=0 || row > height) {
            return false;
        }
        else if (col <=0 || col > width) {
            return false;
        }
        return true;
    }

    private void buildRowContent(int rowNum, StringBuilder sb) {
        for(int col=0; col < width+2; col++) {
            sb.append(pixels[rowNum][col]);
        }
        sb.append(System.getProperty("line.separator"));
    }

    private void setCanvasPerimeter() {
        //set the canvas perimeter
        for (int row = 0; row < height+2; row++) {
            //horizontal perimeter
            if (isHorizontalPerimeter(row)) {
                Arrays.fill(pixels[row], horizPerimiter);
                continue;
            }

            for (int col = 0; col < width + 2; col++) {
                pixels[row][col] = isVerticalPerimeter(col) ? vertPerimieter : ' ';
            }
        }
    }

    public List<DrawableComponent> getAmendments() {
        return this.amendments;
    }

    public boolean isBlank() {
        for(int i=1; i<pixels.length-1; i++) {
            for(int j=1; j<pixels[i].length-1; j++) {
                if(pixels[i][j] != ' ') {
                    return false;
                }
            }
        }
        return amendments.isEmpty();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
