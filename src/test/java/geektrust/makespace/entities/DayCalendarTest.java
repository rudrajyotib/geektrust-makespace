package geektrust.makespace.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DayCalendarTest {

    @Test
    public void shouldIdentifyAvailableSlots() {
        DayCalendar dayCalendar = new DayCalendar();
        assertTrue(dayCalendar.isAvailable(0, 2));
        assertFalse(dayCalendar.isAvailable(33, 37));
    }

    @Test
    public void shouldBookAndMaintainStatus() {
        DayCalendar dayCalendar = new DayCalendar();
        dayCalendar.book(0, 3);
        dayCalendar.book(4, 5);
        dayCalendar.book(5, 7);
        assertTrue(dayCalendar.isAvailable(6, 7));
        assertTrue(dayCalendar.isAvailable(6, 6));
    }


}