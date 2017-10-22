package com.mbans.sandbox.cs.drawingapp;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Encapsulate the features that the Drawing App supports
 * Use regex to validate/identify the corresponding command operation from a command string
 */
public enum AppFeature {

    QUIT("Q"),
    CREATE_CANVAS("C\\s([0-9]+)\\s([0-9]+)"),
    LINE("L\\s([0-9])\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)"),
    RECT("R\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)"),
    FILL("B\\s([0-9]+)\\s([0-9]+)\\s([a-zA-Z])");

    private String regex;

    AppFeature(String regex) {
        this.regex = regex;
    }

    /**
     * Captures the groups (parameters) for the commands
     * Returns group values in list
     * @param command
     * @return
     */
    public List<String> getParameters(String command) {
        Pattern p = Pattern.compile(this.regex);
        Matcher m = p.matcher(command);
        List<String> groups = new ArrayList<String>();
        if(!m.matches()) {
            return null;
        }

        int i=1;
        while(i <= m.groupCount()) {
            groups.add(m.group(i));
            i++;
        }

        return groups;
    }

    public static Map.Entry<AppFeature, List<String>> getFeatureType(String command) {
        for(AppFeature op : AppFeature.values()) {
            List<String> params = op.getParameters(command);
            if(params != null) {
                return new AbstractMap.SimpleEntry(op,params);
            }
        }
        return null;
    }
}
