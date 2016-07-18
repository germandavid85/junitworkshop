package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.RoomDTO;

import java.util.List;

/**
 * Created by gpotesf on 7/13/16.
 */
public class RoomHelper {
    public void populateRoomList(final List<RoomDTO> roomDTOList) {
        roomDTOList.add(new RoomDTO());
        roomDTOList.add(new RoomDTO());
    }
}
