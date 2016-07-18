package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.RoomDTO;

/**
 * Created by gpotesf on 7/12/16.
 */
public class AvailabilityService {

    boolean isRoomAvailable(final RoomDTO roomDTO) {
        // will call persistence layer to find out room's availability
        return true;
    }
}
