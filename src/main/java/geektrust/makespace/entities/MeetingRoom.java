package geektrust.makespace.entities;

public class MeetingRoom {

    private final DayCalendar dayCalendar;
    private final String name;
    private final int capacity;

    public MeetingRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.dayCalendar = new DayCalendar();
    }

    public boolean canAccommodate(int people) {
        return people <= capacity;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable(int slotStart, int slotEnd) {
        return this.dayCalendar.isAvailable(slotStart, slotEnd);
    }

    public void book(int slotStart, int slotEnd) {
        this.dayCalendar.book(slotStart, slotEnd);
    }


}
