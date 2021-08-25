package geektrust.marketplace.api;

import geektrust.marketplace.command.BookingManager;

import java.util.Arrays;

import static geektrust.marketplace.command.BookingManager.INCORRECT_INPUT;

public class SingleCommandProcessor {

    public static String processSingleCommand(String commandLine) {
        if (commandLine == null || commandLine.isEmpty()) {
            return INCORRECT_INPUT;
        }
        String[] arguments = commandLine.split(" ");
        return BookingManager.valueOf(arguments[0]).processCommand(Arrays.copyOfRange(arguments, 1, arguments.length));
    }

}
