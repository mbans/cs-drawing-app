package com.mbans.sandbox.cs.drawingapp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by lumarmacy on 29/10/2017.
 */
public class CommandFactoryTest {

    CommandFactory cf = new CommandFactory();

    @Test
    public void shouldReturnNullForInvalidCommand() {
        Command command = cf.getCommand("some command");
        assertTrue(command == null);
    }

    @Test
    public void shouldReturnCommandForValidInput() {
        assertCommandNotNull("C 1 1");
        assertCommandNotNull("L 1 1 1 2");
        assertCommandNotNull("R 1 1 3 3");
        assertCommandNotNull("Q");
        assertCommandNotNull("B 1 1 x");
    }

    @Test
    public void shouldCreateaCreateCanvasCommand() {
        Command cmd = assertCommandNotNull("C 1 2");
        assertTrue(cmd instanceof CreateCanvasCommand);
        assertThat(cmd.getParameters().get(0), is("1"));
        assertThat(cmd.getParameters().get(1), is("2"));
    }

    private Command assertCommandNotNull(String cmd) {
        Command command = cf.getCommand(cmd);
        assertTrue(command != null);
        return command;
    }


//
//
//
//        QUIT("Q"),
//                CREATE_CANVAS("C\\s([0-9]+)\\s([0-9]+)"),
//                LINE("L\\s([0-9])\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)"),
//                RECT("R\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)\\s([0-9]+)"),
//                FILL("B\\s([0-9]+)\\s([0-9]+)\\s([a-zA-Z])");

//    }



}
