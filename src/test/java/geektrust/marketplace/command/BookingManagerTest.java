package geektrust.marketplace.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingManagerTest {

    @Test
    public void shouldProcessCommands() {
        assertEquals("C-Cave", BookingManager.BOOK.processCommand(new String[]{"11:00", "12:00", "3"}));
        assertEquals("D-Tower", BookingManager.BOOK.processCommand(new String[]{"11:00", "12:00", "2"}));
        assertEquals("G-Mansion", BookingManager.BOOK.processCommand(new String[]{"11:00", "12:00", "20"}));
        assertEquals("NO_VACANT_ROOM", BookingManager.BOOK.processCommand(new String[]{"11:00", "12:00", "5"}));
        assertEquals("NO_VACANT_ROOM", BookingManager.VACANCY.processCommand(new String[]{"11:00", "12:00"}));
        assertEquals("NO_VACANT_ROOM", BookingManager.VACANCY.processCommand(new String[]{"11:30", "12:00"}));
        assertEquals("NO_VACANT_ROOM", BookingManager.VACANCY.processCommand(new String[]{"11:30", "12:30"}));
        assertEquals("C-Cave D-Tower G-Mansion", BookingManager.VACANCY.processCommand(new String[]{"12:15", "12:30"}));
        assertEquals("INCORRECT_INPUT", BookingManager.VACANCY.processCommand(new String[]{"12:25", "12:30"}));
        assertEquals("INCORRECT_INPUT", BookingManager.VACANCY.processCommand(new String[]{"12:15"}));
        assertEquals("INCORRECT_INPUT", BookingManager.VACANCY.processCommand(new String[]{"14:15", "12:30"}));
        assertEquals("INCORRECT_INPUT", BookingManager.BOOK.processCommand(new String[]{"14:15", "12:30", "5"}));
        assertEquals("INCORRECT_INPUT", BookingManager.BOOK.processCommand(new String[]{"14:15", "15:30"}));
        assertEquals("D-Tower", BookingManager.BOOK.processCommand(new String[]{"12:15", "13:15", "5"}));
        assertEquals("C-Cave", BookingManager.BOOK.processCommand(new String[]{"13:00", "13:15", "3"}));
        assertEquals("C-Cave", BookingManager.BOOK.processCommand(new String[]{"13:45", "14:00", "3"}));
        assertEquals("C-Cave", BookingManager.BOOK.processCommand(new String[]{"14:00", "14:15", "3"}));
        assertEquals("INCORRECT_INPUT", BookingManager.BOOK.processCommand(new String[]{"14:15", "14:15", "3"}));
    }


}