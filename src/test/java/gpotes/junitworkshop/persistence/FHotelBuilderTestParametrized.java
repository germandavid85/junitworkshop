package gpotes.junitworkshop.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class FHotelBuilderTestParametrized {

    private long hotelId;
    private String hotelName;
    private Hotel expectedHotel;

    public FHotelBuilderTestParametrized(long hotelId, String hotelName, Hotel expectedHotel) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.expectedHotel = expectedHotel;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Hotel hotel1 = new Hotel();
        hotel1.setHotelId(0L);
        hotel1.setHotelName("Hotel 1");

        Hotel hotel2 = new Hotel();
        hotel2.setHotelId(997L);
        hotel2.setHotelName("Hotel 2");

        return Arrays.asList(new Object[][] {
            { 0L, "Hotel 1", hotel1 },
            { 997L, "Hotel 2", hotel2 }
        });
    }

    @Test
    public void testHotelBuilder() {
        HotelBuilder hotelBuilder = new HotelBuilder();
        hotelBuilder.setHotelId(hotelId).setHotelName(hotelName);

        assertThat(hotelBuilder.build(), is(equalTo(expectedHotel)));
    }
}
