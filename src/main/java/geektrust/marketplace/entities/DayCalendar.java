package geektrust.marketplace.entities;

public class DayCalendar {


    private final boolean[] slots;


    public DayCalendar() {
        slots = new boolean[96];
        slots[36] = true;
        slots[53] = true;
        slots[54] = true;
        slots[75] = true;
    }

    public boolean isAvailable(int startSlot, int endSlot) {
        for (int i = startSlot; i <= endSlot; i++) {
            if (slots[i]) {
                return false;
            }
        }
        return true;
    }

    public void book(int startSlot, int endSlot) {
        if (isAvailable(startSlot, endSlot)) {
            for (int i = startSlot; i <= endSlot; i++) {
                slots[i] = true;
            }
        }
    }

}
