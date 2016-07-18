package gpotes.junitworkshop.model;

public class RoomDTO {

    private String roomName;
    private RoomType roomType;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(final String roomName) {
        this.roomName = roomName;
    }

    public void setRoomType(final RoomType roomType) {
        this.roomType = roomType;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}
