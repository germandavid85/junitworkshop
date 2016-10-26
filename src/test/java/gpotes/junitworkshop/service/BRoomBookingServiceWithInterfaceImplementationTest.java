package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * This test class contains the following:
 *   - How to test and exception with ExpectedException rule
*    - Use of spy / partial mock
 *   -
 */
@RunWith(MockitoJUnitRunner.class)
public class BRoomBookingServiceWithInterfaceImplementationTest {

    private IRoomBookingService serviceSUT;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        serviceSUT = new RoomBookingService(new DiscountsService());
    }

    @Test
    public void fullHotelThenIShouldHaveNoAvailability() {

        assertFalse("Invalid available rooms count", serviceSUT.hasAvailableRooms(new HotelDTO()));
    }

    @Test (expected=NullPointerException.class)
    public void noAvailabilityWithNullRooms() {
        serviceSUT.hasAvailableRooms(null);
    }

    @Test
    public void noAvailabilityWithNullRoomsDetailed() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("hotelDTO should be not null");

        serviceSUT.hasAvailableRooms(null);
    }
}
