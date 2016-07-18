package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import gpotes.junitworkshop.model.RoomDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.anyObject;
import static org.mockito.Mockito.when;

/**
 * This test class contains:
 *   - Mock injection via constructor
 *   - Use of matchers
 */
@RunWith(MockitoJUnitRunner.class)
public class CRoomBookingServiceTestWithConstructorDI {

    @Mock private DiscountsService mockDiscountService;

    private RoomDTO thirdFloorRoom ;
    private RoomDTO presidentialSuite;
    private RoomDTO firstFloorRoom;
    private RoomDTO secondFloorRoom;

    private IRoomBookingService serviceSUT;

    private HotelDTO hotelDTO;

    @Before
    public void setup() {
        serviceSUT = new RoomBookingService(mockDiscountService);

        setupHotel();
    }

    @Test
    public void noDiscountRoomsThenIShouldNoHaveAnyResult() {
        when(mockDiscountService.acceptsDiscounts(anyObject())).thenReturn(false);

        assertThat(serviceSUT.getBestPriceRooms(hotelDTO).size(), is(0));
    }

    @Test
    public void haveDiscountRoomsThenIShouldNoHaveResults() {
        when(mockDiscountService.acceptsDiscounts(thirdFloorRoom)).thenReturn(true);
        when(mockDiscountService.acceptsDiscounts(presidentialSuite)).thenReturn(false);
        when(mockDiscountService.acceptsDiscounts(firstFloorRoom)).thenReturn(false);
        when(mockDiscountService.acceptsDiscounts(secondFloorRoom)).thenReturn(true);

        // you can also do this:
        // when(mockDiscountService.acceptsDiscounts(secondFloorRoom)).thenCallRealMethod();
        // to call the actual method, as another option of partial mocking

        List<RoomDTO> returnedRooms = serviceSUT.getBestPriceRooms(hotelDTO);
        assertThat(returnedRooms.size(), is(2));
        assertThat(returnedRooms, hasItem(thirdFloorRoom));
        assertThat(returnedRooms, hasItem(secondFloorRoom));
    }

    private void setupHotel() {
        thirdFloorRoom = new RoomDTO();
        presidentialSuite = new RoomDTO();
        firstFloorRoom = new RoomDTO();
        secondFloorRoom = new RoomDTO();

        hotelDTO = new HotelDTO();
        hotelDTO.setRoomDTOList(Arrays.asList(thirdFloorRoom, presidentialSuite, firstFloorRoom, secondFloorRoom));
    }
}
