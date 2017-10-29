package com.mbans.sandbox.cs.drawingapp;


import java.util.Scanner;

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
    private CommandFactory cf = new CommandFactory();

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

        Command cmd = cf.getCommand(command);
        if(cmd != null) {
            this.canvas = cmd.execute(canvas);
        } else {
            printUsage();
        }
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

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
