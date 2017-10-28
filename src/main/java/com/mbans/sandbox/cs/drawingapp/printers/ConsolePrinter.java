package com.mbans.sandbox.cs.drawingapp;

public class ConsolePrinter  implements Printer {

    public void print(final StringBuilder sb) {
        System.out.println(sb);
    }
}
