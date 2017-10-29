package com.mbans.sandbox.cs.drawingapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lumarmacy on 29/10/2017.
 */
public class CommandFactory {

    private Map<String, Function<String,Command>> regexes = new HashMap<>();

    public CommandFactory() {
        regexes.put("Q", input->new QuitCommand());
        regexes.put("C\\s([0-9]+)\\s([0-9]+)", input->new CreateCanvasCommand());
        regexes.put("L\\s([0-9])\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)", input->new AddLineCommand());
        regexes.put("R\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)", input->new RectangleCommand());
        regexes.put("B\\s([0-9]+)\\s([0-9]+)\\s([a-zA-Z])", input->new FillCommand());
    }

    public Command getCommand(String input) {
        final List<String> params = new ArrayList<>();

        Predicate<String> pred = regex -> {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);
            if (m.matches()) {
                int i=1;
                while(i <= m.groupCount()) {
                    params.add(m.group(i));
                    i++;
                }

                return true;
            }
            return false;
        };

        List<String> matches = regexes.keySet().stream().filter(pred).collect(Collectors.toList());
        if(matches.isEmpty()) {
            return null;
        }

        Command cmd = regexes.get(matches.get(0)).apply(input);
        cmd.setParameters(params);

        return cmd;
    }
}
