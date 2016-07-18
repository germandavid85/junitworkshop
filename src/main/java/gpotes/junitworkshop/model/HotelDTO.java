package gpotes.junitworkshop.model;

import java.util.ArrayList;
import java.util.List;

public class HotelDTO {
    private long hotelId;
    private final List<RoomDTO> roomDTOList = new ArrayList<>();

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setRoomDTOList(final List<RoomDTO> roomDTOList) {
        this.roomDTOList.clear();
        this.roomDTOList.addAll(roomDTOList);
    }

    public List<RoomDTO> getRoomList() {
        return new ArrayList<>(roomDTOList);
    }
}
