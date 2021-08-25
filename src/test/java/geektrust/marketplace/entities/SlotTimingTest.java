package geektrust.marketplace.entities;

import geektrust.marketplace.exceptions.InvalidSlotException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SlotTimingTest {

    @Test
    public void shouldParseValidTimes() throws InvalidSlotException {
        assertEquals(0, SlotTiming.parseTimeToSlot("00:00"));
        assertEquals(1, SlotTiming.parseTimeToSlot("00:15"));
        assertEquals(45, SlotTiming.parseTimeToSlot("11:15"));
        assertEquals(95, SlotTiming.parseTimeToSlot("23:45"));
    }

    @Test
    public void shouldNotParseTimingWithMoreCharacters() {
        assertThrows(InvalidSlotException.class, () -> SlotTiming.parseTimeToSlot("00:000"));
    }

    @Test
    public void shouldNotParseTimingWithNotEnoughCharacters() {
        assertThrows(InvalidSlotException.class, () -> SlotTiming.parseTimeToSlot("00:0"));
    }

    @Test
    public void shouldNotParseTimingWithInvalidMinute() {
        assertThrows(InvalidSlotException.class, () -> SlotTiming.parseTimeToSlot("00:02"));
    }

    @Test
    public void shouldNotParseTimingWithInvalidHour() {
        assertThrows(InvalidSlotException.class, () -> SlotTiming.parseTimeToSlot("30:00"));
    }


}