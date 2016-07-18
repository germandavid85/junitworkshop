package gpotes.junitworkshop.persistence;

/**
 * Created by gpotesf on 7/13/16.
 */
public final class HotelBuilder {

    private String hotelName;
    private long hotelId;

    public HotelBuilder setHotelName(final String hotelName) {
        this.hotelName = hotelName;
        return this;
    }

    public HotelBuilder setHotelId(final long hotelId) {
        this.hotelId = hotelId;
        return this;
    }

    public Hotel build() {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setHotelId(hotelId);

        return hotel;
    }
}
