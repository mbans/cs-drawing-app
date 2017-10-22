package com.mbans.sandbox.cs.drawingapp;

import java.awt.Point;

public class Pixel {

    private Point point;
    private char symbol;

    public Pixel(Point point, char symbol) {
        this.point = point;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pixel)) return false;

        Pixel pixel = (Pixel) o;

        if (symbol != pixel.symbol) return false;
        return point.equals(pixel.point);

    }

    @Override
    public int hashCode() {
        int result = point.hashCode();
        result = 31 * result + (int) symbol;
        return result;
    }
}
