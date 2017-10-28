package com.mbans.sandbox.cs.drawingapp;

public class TestConsolePrinter extends ConsolePrinter {

    private boolean didPrint = false;

    @Override
    public void print(final StringBuilder sb) {
        super.print(sb);
        this.didPrint = true;
    }

    public boolean didPrint() {
        return this.didPrint;
    }
}
