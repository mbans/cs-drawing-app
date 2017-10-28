package com.mbans.sandbox.cs.drawingapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lumarmacy on 28/10/2017.
 */
public class CommandFactory {

    private List<String> regexes = new ArrayList<>();

    private Map<String, Function<String,Command>> regexMap = new HashMap<>();


    public CommandFactory() {

        Function<String,Command>
        this.regexes.add("C\\s([0-9]+)\\s([0-9]+)", input-> new CreateCanvasCommand(input));    //create canvas
        this.regexes.add("L\\s([0-9])\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)", input -> new AddLineCommand()); //add line
        this.regexes.add("Q"); //add line
        this.regexes.add("R\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)"); //rect
        this.regexes.add("B\\s([0-9]+)\\s([0-9]+)\\s([a-zA-Z])"); //fill

    }

    public Command create(String userInput) {
        for(String regex : regexes) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(userInput);
            if (m.matches()) {
            }
        }
        return null;
    }
}
