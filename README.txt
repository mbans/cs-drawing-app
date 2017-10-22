-----------------------
Running the application
-----------------------

After copying over the source code

1. cd cs-drawing-app

-- Compile code and run tests
2. mvn clean test

-- This will run the main class com.mbans.sandbox.cs.drawingapp.DrawingApp
3. mvn exec:java


Will be prompted to enter command.
Supported commands are:
C w h           -- creates canvas of with 'w' and height 'h'
L x1 y1 x2 y2   -- draws a line onto the canvas from points (x1,y1) to (y1,y2), only horizontal and vertical lines supported
R x1 y1 x1 x2   -- draws a rectangle onto the canvas from points (x1,y1) to (x2,y2)
B x y c         -- fills the area of canvas connected to (x,y) with 'c'
Q               -- quit the application



-------------
Special Cases:
-------------
1. Components that are out with the boundary of the canvas will be partially drawn
2. Canvas' top left co-ordinate will start from (1,1)
3. Canvas must be created before attempting to draw to it, an excpetion message will be displayed otherwise

----
Line
----
1. Only horizontal and vertical lines supported, other lines will be not be drawn onto the cavas

---------
Rectangle
---------
1. Different points should be supplied when constructing rectangle
e.g. "R 1 1 3 3" is valid
     "R 1 1 1 1" is invalid



