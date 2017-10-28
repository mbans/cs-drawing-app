package com.mbans.sandbox.cs.drawingapp.commands;

import com.mbans.sandbox.cs.drawingapp.Canvas;

import java.util.List;

/**
 * Created by lumarmacy on 28/10/2017.
 */
public abstract class Command {

    protected List<String> parameters;

    public abstract Canvas execute(final Canvas canvas);

    void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

}
