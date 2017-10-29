package com.mbans.sandbox.cs.drawingapp;

import org.junit.Before;
import org.junit.Test;

import static com.mbans.sandbox.cs.drawingapp.BucketFillTest.canvasIs;
import static org.junit.Assert.assertTrue;

public class DrawingAppTest {

    private DrawingApp app;

    @Before
    public void setup() {
        app = new DrawingApp();
        app.setCanvas(new Canvas(5,5));
    }

    @Test
    public void shouldCreateCanvas() {
        DrawingApp newApp = new DrawingApp();
        newApp.execute("C 3 3");
        assertTrue(newApp.getCanvas().getHeight()==3 &&
                          newApp.getCanvas().getWidth() ==3);
    }

    @Test
    public void shouldCreateLine() {
        //Given
        app.execute("L 1 1 1 3");
        canvasIs(
                app.getCanvas(), new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', 'x', ' ', ' ', ' ', ' ', '|'},
                        {'|', 'x', ' ', ' ', ' ', ' ', '|'},
                        {'|', 'x', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'},
                });
    }

    @Test
    public void shouldCreateRectangle() {
        app.execute("R 1 1 4 4");
        canvasIs(
                app.getCanvas(), new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', 'x', 'x', 'x', 'x', ' ', '|'},
                        {'|', 'x', ' ', ' ', 'x', ' ', '|'},
                        {'|', 'x', ' ', ' ', 'x', ' ', '|'},
                        {'|', 'x', 'x', 'x', 'x', ' ', '|'},
                        {'|', ' ', ' ', ' ', ' ', ' ', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'},
                });
    }

    @Test
    public void shouldFill() {
        app.execute("R 1 1 4 4");
        app.execute("B 1 5 c");
        canvasIs(
                app.getCanvas(), new char[][]{
                        {'-', '-', '-', '-', '-', '-', '-'},
                        {'|', 'x', 'x', 'x', 'x', 'c', '|'},
                        {'|', 'x', ' ', ' ', 'x', 'c', '|'},
                        {'|', 'x', ' ', ' ', 'x', 'c', '|'},
                        {'|', 'x', 'x', 'x', 'x', 'c', '|'},
                        {'|', 'c', 'c', 'c', 'c', 'c', '|'},
                        {'-', '-', '-', '-', '-', '-', '-'},
                });
    }

    @Test
    public void shouldQuit() {
        //TODO: use expectedSystemExit rule (junit 4.9)
        //app.execute("Q");
    }

}