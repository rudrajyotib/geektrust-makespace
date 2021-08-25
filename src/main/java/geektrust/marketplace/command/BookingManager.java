package geektrust.marketplace.command;

import geektrust.marketplace.entities.MeetingRoom;
import geektrust.marketplace.entities.SlotTiming;
import geektrust.marketplace.exceptions.InvalidSlotException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum BookingManager {

    VACANCY {
        @Override
        public String processCommand(String[] args) {
            try {
                if (args.length != 2) {
                    return INCORRECT_INPUT;
                }
                int startSlot = SlotTiming.parseTimeToSlot(args[0]);
                int endSlot = SlotTiming.parseTimeToSlot(args[1]) - 1;

                if (endSlot < startSlot) {
                    return INCORRECT_INPUT;
                }

                String vacancies = meetingRooms
                        .stream()
                        .filter(meetingRoom -> meetingRoom.isAvailable(startSlot, endSlot))
                        .map(MeetingRoom::getName)
                        .collect(Collectors.joining(" "));

                if (vacancies.isEmpty()) {
                    return NO_VACANT_ROOM;
                }
                return vacancies;
            } catch (InvalidSlotException e) {
                return INCORRECT_INPUT;
            }
        }
    },
    BOOK {
        @Override
        public String processCommand(String[] args) {
            try {
                if (args.length != 3) {
                    return INCORRECT_INPUT;
                }
                int startSlot = SlotTiming.parseTimeToSlot(args[0]);
                int endSlot = SlotTiming.parseTimeToSlot(args[1]) - 1;
                if (endSlot < startSlot) {
                    return INCORRECT_INPUT;
                }
                int people = Integer.parseInt(args[2]);
                Optional<MeetingRoom> availableRoom = meetingRooms
                        .stream()
                        .filter(meetingRoom -> meetingRoom.canAccommodate(people) && meetingRoom.isAvailable(startSlot, endSlot))
                        .findFirst();
                if (availableRoom.isPresent()) {
                    availableRoom.get().book(startSlot, endSlot);
                    return availableRoom.get().getName();
                }
                return NO_VACANT_ROOM;
            } catch (InvalidSlotException e) {
                return INCORRECT_INPUT;
            }
        }
    };

    public static final String NO_VACANT_ROOM = "NO_VACANT_ROOM";
    public static final String INCORRECT_INPUT = "INCORRECT_INPUT";
    public static List<MeetingRoom> meetingRooms
            = new ArrayList<MeetingRoom>(3) {
        {
            add(new MeetingRoom("C-Cave", 3));
            add(new MeetingRoom("D-Tower", 7));
            add(new MeetingRoom("G-Mansion", 20));
        }
    };

    public abstract String processCommand(String[] args);
}

