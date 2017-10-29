package com.mbans.sandbox.cs.drawingapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lumarmacy on 29/10/2017.
 */
public class Command {

    private List<String> parameters = new ArrayList<>();

    public Canvas execute(Canvas canvas) {
        return canvas;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public boolean isCanvasNull(Canvas c) {
        if (c == null) {
            System.out.println("Create a canvas before attempting to draw");
            System.out.println();
            return true;
        }
        return false;
    }
}
