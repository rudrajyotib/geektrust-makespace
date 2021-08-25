package geektrust.marketplace.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomTest {

    @Test
    public void shouldSupportBookAndEnquiries() {
        MeetingRoom meetingRoom = new MeetingRoom("M1", 10);
        assertEquals("M1", meetingRoom.getName());
        assertTrue(meetingRoom.canAccommodate(10));
        assertFalse(meetingRoom.canAccommodate(11));
        assertTrue(meetingRoom.isAvailable(0, 2));
        meetingRoom.book(3, 10);
        assertFalse(meetingRoom.isAvailable(4, 8));
        meetingRoom.book(9, 12);
        assertTrue(meetingRoom.isAvailable(11, 12));

    }


}