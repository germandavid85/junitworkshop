package gpotes.junitworkshop.persistence;

public class Hotel {
    private String hotelName;
    private long hotelId;

    public String getHotelName() {
        return hotelName;
    }

    void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public long getHotelId() {
        return hotelId;
    }

    void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (hotelId != hotel.hotelId) return false;
        return hotelName != null ? hotelName.equals(hotel.hotelName) : hotel.hotelName == null;

    }

    @Override
    public int hashCode() {
        int result = hotelName != null ? hotelName.hashCode() : 0;
        result = 31 * result + (int) (hotelId ^ (hotelId >>> 32));
        return result;
    }
}
