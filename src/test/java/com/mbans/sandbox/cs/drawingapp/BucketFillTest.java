package com.mbans.sandbox.cs.drawingapp;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static com.mbans.sandbox.cs.drawingapp.RectangleTest.p;

public class BucketFillTest {

    private Canvas c = new Canvas(5,5);

    @Test
    public void shouldFillBlankCanvas() {
        //Given - create a rectangle
        BucketFill fill = new BucketFill(c, new Point(1,1), 'o');

        //When
        fill.draw();

        //Then - canvas updated
        List<DrawableComponent> amendments = c.getAmendments();
        Assert.assertTrue(amendments.contains(fill));
        canvasIs(
                c,  new char[][] {
                        {'-','-','-','-','-','-','-'  },
                        {'|', 'o','o','o','o','o', '|'},
                        {'|', 'o','o','o','o','o' ,'|'},
                        {'|', 'o','o','o','o','o' ,'|'},
                        {'|', 'o','o','o','o','o' ,'|'},
                        {'|', 'o','o','o','o','o' ,'|'},
                        {'-','-','-','-','-','-','-'  },
                });
    }

   @Test
   public void shouldFillWithContentAlreadyOnCavas() {

        //1. Add rectngle
        Rectangle rect = new Rectangle(c, p(1,1), p(4,4), 'x');
        rect.draw();
        canvasIs(
               c,  new char[][] {
                       {'-','-','-','-','-','-','-'  },
                       {'|', 'x','x','x','x',' ', '|'},
                       {'|', 'x',' ',' ','x',' ' ,'|'},
                       {'|', 'x',' ',' ','x',' ' ,'|'},
                       {'|', 'x','x','x','x',' ' ,'|'},
                       {'|', ' ',' ',' ',' ',' ' ,'|'},
                       {'-','-','-','-','-','-','-'  },
               });


           //2. Fill around the rectangle
           BucketFill externalFill = new BucketFill(c, new Point(5,5), 'o');
           externalFill.draw();

           //Then
           canvasIs(
               c,  new char[][] {
                       {'-','-','-','-','-','-','-'  },
                       {'|', 'x','x','x','x','o', '|'},
                       {'|', 'x',' ',' ','x','o' ,'|'},
                       {'|', 'x',' ',' ','x','o' ,'|'},
                       {'|', 'x','x','x','x','o' ,'|'},
                       {'|', 'o','o','o','o','o' ,'|'},
                       {'-','-','-','-','-','-','-'  },
               });

          //3. Fill inside the rectangle
         BucketFill internalFill = new BucketFill(c, new Point(2,2), 'i');
         internalFill.draw();

         //Then
         canvasIs(
               c,  new char[][] {
                       {'-','-','-','-','-','-','-'  },
                       {'|', 'x','x','x','x','o', '|'},
                       {'|', 'x','i','i','x','o' ,'|'},
                       {'|', 'x','i','i','x','o' ,'|'},
                       {'|', 'x','x','x','x','o' ,'|'},
                       {'|', 'o','o','o','o','o' ,'|'},
                       {'-','-','-','-','-','-','-'  },
               });
   }

    public static void canvasIs(Canvas c, char[][] expectedValues) {
        for(int i=0; i<expectedValues.length; i++) { //row
            for(int j=0; j<expectedValues[i].length; j++) { //col
                Assert.assertTrue(c.getPixel(i, j) == expectedValues[i][j]);
            }
        }
    }

}
