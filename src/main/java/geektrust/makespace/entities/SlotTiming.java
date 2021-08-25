package geektrust.makespace.entities;

import geektrust.makespace.exceptions.InvalidSlotException;

import java.util.HashMap;
import java.util.Map;

public class SlotTiming {

    private static final Map<String, Integer> validMinutes = new HashMap<String, Integer>() {
        {
            put("00", 0);
            put("15", 1);
            put("30", 2);
            put("45", 3);
        }
    };

    public static int parseTimeToSlot(String timing) throws InvalidSlotException {
        if (timing.length() != 5) {
            throw new InvalidSlotException("Timing text does not have correct length");
        }
        if (timing.charAt(2) != ':') {
            throw new InvalidSlotException("Timing text separator not present");
        }
        String[] hourAndMinute = timing.split(":");
        if (hourAndMinute.length != 2) {
            throw new InvalidSlotException("Timing not split into 2 pieces");
        }
        if (!validMinutes.containsKey(hourAndMinute[1])) {
            throw new InvalidSlotException("Minute part of time is not correct");
        }
        int hour = Integer.parseInt(hourAndMinute[0]);
        if (hour < 0 || hour > 23) {
            throw new InvalidSlotException("Hour part is beyond day limit");
        }
        return (hour * 4) + validMinutes.get(hourAndMinute[1]);
    }

}
