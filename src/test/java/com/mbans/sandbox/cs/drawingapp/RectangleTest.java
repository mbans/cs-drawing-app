package com.mbans.sandbox.cs.drawingapp;

import org.junit.Test;

import java.awt.*;
import java.util.List;

import static com.mbans.sandbox.cs.drawingapp.BucketFillTest.canvasIs;
import static org.junit.Assert.assertTrue;

public class RectangleTest {


    private Canvas c = new Canvas(5,5);

    @Test
    public void shouldCreateRectangle() {
        //Given - create a rectangle
        Rectangle r = new Rectangle(c, new Point(1,1), new Point(3,3), 'x');

        //When
        r.draw();

        //Then - canvas updated
        List<DrawableComponent> amendments = c.getAmendments();
        assertTrue(amendments.size() == 1);
        assertTrue(amendments.contains(r));

        canvasIs(
                c, new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', 'x', 'x', 'x', ' ', ' ', '|'},
                        {'|', 'x', ' ', 'x', ' ', ' ', '|'},
                        {'|', 'x', 'x', 'x', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'}
                });
    }


    @Test
    public void shouldNotCreateSinglePixelRectangle() {
        //Given - create a rectangle
        Rectangle r = new Rectangle(c, new Point(1,1), new Point(1,1), 'x');

        //When
        r.draw();

        //Then - blank canvas
        assertTrue(c.isBlank());
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

    @Test
    public void shouldPartiallyRenderTriangle() {
        //given
        Rectangle r = new Rectangle(c, new Point(4,1), new Point(8,3), 'x');

        //When
        r.draw();

        //Then
        canvasIs(
                c, new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', ' ', ' ', ' ', 'x', 'x', '|'},
                        {'|', ' ', ' ', ' ', 'x', ' ', '|'},
                        {'|', ' ', ' ', ' ', 'x', 'x', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'}
                });
    }

    public static Point p(int x, int y) {
        return new Point(x,y);
    }
}
