package geektrust.marketplace.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleCommandProcessorTest {

    @Test
    public void shouldProcessSingleCommand() {
        assertEquals("C-Cave", SingleCommandProcessor.processSingleCommand("BOOK 11:00 12:00 3"));
        assertEquals("D-Tower", SingleCommandProcessor.processSingleCommand("BOOK 11:00 12:00 2"));
        assertEquals("G-Mansion", SingleCommandProcessor.processSingleCommand("BOOK 11:00 12:00 20"));
        assertEquals("NO_VACANT_ROOM", SingleCommandProcessor.processSingleCommand("BOOK 11:00 12:00 5"));
        assertEquals("NO_VACANT_ROOM", SingleCommandProcessor.processSingleCommand("VACANCY 11:00 12:00"));
        assertEquals("NO_VACANT_ROOM", SingleCommandProcessor.processSingleCommand("VACANCY 11:30 12:00 5"));
        assertEquals("NO_VACANT_ROOM", SingleCommandProcessor.processSingleCommand("VACANCY 11:30 12:30 5"));
        assertEquals("C-Cave D-Tower G-Mansion", SingleCommandProcessor.processSingleCommand("VACANCY 12:15 12:30"));
    }

    @Test
    public void shouldNotProcessInvalidCommands() {
        assertEquals("INVALID_OPTION", SingleCommandProcessor.processSingleCommand("BOOK "));
    }


}