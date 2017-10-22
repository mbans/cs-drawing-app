package com.mbans.sandbox.cs.drawingapp;


import java.awt.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import static com.mbans.sandbox.cs.drawingapp.AppFeature.getFeatureType;
import static java.lang.Integer.parseInt;

/**
 * Drawing application that allows users to issue commands to perform
 * standard operations, these include:
 *
 * <ul>
 *  <li>Create canvas</li>
 *  <li>Add line to canvas</li>
 *  <li>Add rectabgle to canvas</li>
 *  <li>Apply bucket fill operation to canvas</li>
 *  <li>Quit application</li>
 * </ul>
 *
 */
public class DrawingApp {

    private Canvas canvas;

    //Main App
    public static void main(String[] args) {
        DrawingApp app = new DrawingApp();
        while(true) {
            System.out.print("Enter command: ");
            Scanner scanner = new Scanner(System.in);
            app.execute(scanner.nextLine());
        }
    }


    /**
     * Parse user commands and apply accordingly
     * @param command issued by user
     */
    protected void execute(String command) {
        if(command.isEmpty()) {
            printUsage();
            return;
        }

        Entry<AppFeature, List<String>> cmd = getFeatureType(command);
        if(cmd == null) {
            printUsage();
            return;
        }

        //Retrieve the operation and associated parameter values
        AppFeature feature = cmd.getKey();
        List<String> params = cmd.getValue();

        //execute
        switch(feature) {
            case QUIT: quit();
            case CREATE_CANVAS:
                int width = parseInt(params.get(0));
                int height = parseInt(params.get(1));
                createCanvas(width,height);
                break;
            case LINE:
                Point start = new Point(parseInt(params.get(0)), parseInt(params.get(1)));
                Point end = new Point(parseInt(params.get(2)), parseInt(params.get(3)));
                amend(new Line(canvas, start, end, 'x'));
                break;
            case RECT:
                start = new Point(parseInt(params.get(0)), parseInt(params.get(1)));
                end = new Point(parseInt(params.get(2)), parseInt(params.get(3)));
                amend(new Rectangle(canvas, start, end, 'x'));
                break;
            case FILL:
                start = new Point(parseInt(params.get(0)), parseInt(params.get(1)));
                char fillSymbol = params.get(2).charAt(0);
                amend(new BucketFill(canvas, start, fillSymbol));
                break;
            default:
                System.out.println("Invalid command '"+command+ "'");;
                break;
        }
    }

    protected void createCanvas(int width, int height) {
        this.canvas = new Canvas(width, height);
    }

    private void quit() {
        System.out.println("Quitting application");
        System.exit(0);
    }

    private void amend(DrawableComponent amendment) {
        if(this.canvas == null) {
            System.out.println("Create a canvas before attempting to draw");
            System.out.println();
            return;
        }
        amendment.draw();
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    private void printUsage() {
        System.out.println("Invalid Command, try again");
        System.out.println("Usage: ");
        System.out.println("   C w h           -- creates canvas of with 'w' and height 'h'");
        System.out.println("   L x1 y1 x2 y2   -- draws a line onto the canvas from points (x1,y1) to (y1,y2), only horizontal and vertical lines supported");
        System.out.println("   R x1 y1 x1 x2   -- draws a rectangle onto the canvas from points (x1,y1) to (x2,y2)");
        System.out.println("   B x y c         -- fills the area of canvas connected to (x,y) with 'c'");
        System.out.println("   Q               -- quit the application");
        System.out.println();
    }
}
