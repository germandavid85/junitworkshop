package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void emptyHotelThenIShouldHaveAvailability() {

        // usually spies are a code smell, if possible review and change the design of you base class
        // instead of using an spy
        IRoomBookingService spyService = Mockito.spy(serviceSUT);
        doReturn(30).when(spyService).getAvailableRoomsCount();
        assertTrue("Invalid available rooms count", spyService.hasAvailableRooms(new HotelDTO()));
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
