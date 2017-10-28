package com.mbans.sandbox.cs.drawingapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by lumarmacy on 28/10/2017.
 */
public class FilePrinter implements Printer {

    private final String path;

    public FilePrinter(String path) {
        this.path = path;
    }

    @Override
    public void print(StringBuilder toPrint) {
        File file = new File(path);
        if(file.exists()) {
            System.out.println("file exists");
        }
        else {
            //Created file
            try {
                System.out.println("Creating file and writing content");
                FileWriter fw = new FileWriter(path);
                fw.write(toPrint.toString());
                fw.close();
            }
            catch(Exception e) {
                System.out.println("Exception writing to file " + path);
                //TODO:
            }
        }
    }
}
