package gpotes.junitworkshop.persistence;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiscountsPersistenceService {
    private HotelBuilder hotelBuilder = new HotelBuilder();

    public List<Float> getListOfDiscountsByHotelId(final long hotelId) {
        Connection connection = PersistenceUtil.getDBConnection();
        // use the connection to get the data
        return new ArrayList<>();
    }

    public List<Hotel> getAllExistingHotels() {
        // get all hotels from DB and use builder to create them

        Hotel hotel = hotelBuilder.setHotelId(334L).setHotelName("Juan Maria").build();

        return Arrays.asList(hotel);

    }
}
