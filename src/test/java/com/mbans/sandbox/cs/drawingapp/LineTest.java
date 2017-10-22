package com.mbans.sandbox.cs.drawingapp;

import org.junit.Test;

import java.awt.*;

import static com.mbans.sandbox.cs.drawingapp.BucketFillTest.canvasIs;

public class LineTest {

    private Canvas c = new Canvas(5,5);

    @Test
    public void shouldCreateVerticallLine() {
        //Given
        Line l = createLine(1, 1, 1, 3);

        //When
        l.draw();

        //Then - canvas updated
        canvasIs(
                c,  new char[][] {
                        {'-','-','-','-','-','-','-'  },
                        {'|', 'x',' ',' ',' ',' ', '|'},
                        {'|', 'x',' ',' ',' ',' ' ,'|'},
                        {'|', 'x',' ',' ',' ',' ' ,'|'},
                        {'|', ' ',' ',' ',' ',' ' ,'|'},
                        {'|', ' ',' ',' ',' ',' ' ,'|'},
                        {'-','-','-','-','-','-','-'  },
                });
    }

    @Test
    public void shouldCreateHorizontalLine() {
        //Given
        Line l = createLine(1, 1, 3, 1);

        //When
        l.draw();

        //Then - canvas updated
        canvasIs(
                c, new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', 'x', 'x', 'x', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'}
                });
    }

    @Test
    public void  shouldCreateSinglePixelLine() {
        //Given
        Line l = createLine(1, 1, 1, 1);

        //When
        l.draw();

        //Then - canvas updated
        canvasIs(
                c, new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', 'x', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'}
                });

    }

    /**
     * Non horizontal and non vertical lines are not supported
     */
    @Test
    public void shouldNotCreateLine() {
        //Given
        Line l = createLine(1, 1, 3, 4);

        //When
        l.draw();

        //Then - canvas not updated
        canvasIs(
                c, new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'}
                });

    }

    private Line createLine(int x1, int y1, int x2, int y2) {
        return new Line(c, new Point(x1, y1), new Point(x2, y2), 'x');
    }
}