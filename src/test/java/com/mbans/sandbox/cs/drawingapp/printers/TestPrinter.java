package com.mbans.sandbox.cs.drawingapp;

import com.mbans.sandbox.cs.drawingapp.printers.Printer;

public class TestPrinter implements Printer {

    private boolean didPrint = false;

    @Override
    public void print(final StringBuilder sb) {
        this.didPrint = true;
    }

    public boolean didPrint() {
        return this.didPrint;
    }
}
