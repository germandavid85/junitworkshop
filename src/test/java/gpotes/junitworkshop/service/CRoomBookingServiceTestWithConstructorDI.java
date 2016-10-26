package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import gpotes.junitworkshop.model.RoomDTO;
import gpotes.junitworkshop.model.RoomType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This test class contains:
 *   - Mock injection via constructor
 *   - Use of matchers
 */
@RunWith(MockitoJUnitRunner.class)
public class CRoomBookingServiceTestWithConstructorDI {
    private DiscountsService discountService = new DiscountsService();

    private RoomDTO thirdFloorRoom ;
    private RoomDTO presidentialSuite;
    private RoomDTO firstFloorRoom;
    private RoomDTO secondFloorRoom;

    private IRoomBookingService serviceSUT;

    private HotelDTO hotelDTO;

    @Before
    public void setup() {
        serviceSUT = new RoomBookingService(discountService);

        setupHotel();
    }

    @Test
    public void noDiscountRoomsThenIShouldNoHaveAnyResult() {
        hotelDTO.setRoomDTOList(Arrays.asList(presidentialSuite, firstFloorRoom));

        List<RoomDTO> bestPricesRooms = serviceSUT.getBestPriceRooms(hotelDTO);
        assertThat(bestPricesRooms.size(), is(0));
    }

    @Test
    public void haveDiscountRoomsThenIShouldNoHaveResults() {
        List<RoomDTO> returnedRooms = serviceSUT.getBestPriceRooms(hotelDTO);
        assertThat(returnedRooms.size(), is(2));
        assertThat(returnedRooms, hasItem(thirdFloorRoom));
        assertThat(returnedRooms, hasItem(secondFloorRoom));
    }

    private void setupHotel() {
        thirdFloorRoom = new RoomDTO();
        thirdFloorRoom.setRoomType(RoomType.SINGLE_ROOM);
        presidentialSuite = new RoomDTO();
        firstFloorRoom = new RoomDTO();
        secondFloorRoom = new RoomDTO();
        secondFloorRoom.setRoomType(RoomType.SINGLE_ROOM);

        hotelDTO = new HotelDTO();
        hotelDTO.setRoomDTOList(Arrays.asList(thirdFloorRoom, presidentialSuite, firstFloorRoom, secondFloorRoom));
    }
}
