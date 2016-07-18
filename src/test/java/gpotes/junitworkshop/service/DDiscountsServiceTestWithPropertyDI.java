package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import gpotes.junitworkshop.model.RoomDTO;
import gpotes.junitworkshop.model.RoomType;
import gpotes.junitworkshop.persistence.DiscountsPersistenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

/**
 * This test class contains:
 *   - dependency injection using InjectMocks
 *   - argument captor
 */
@RunWith(MockitoJUnitRunner.class)
public class DDiscountsServiceTestWithPropertyDI {
    private static final long HOTEL_ID = 867L;
    private static final String ROOM_NAME = "Tiger room";

    @Mock private DiscountsPersistenceService mockDiscountsPersistenceService;
    @Mock private AvailabilityService mockAvailabilityService;
    @Mock private RoomHelper mockRoomHelper;
    // Note: inject mocks annotation will create the instance and will inject the mock by property
    // also the mock can be injected by constructor and setter method
    // use inject mocks carefully as it is stated on its documentation, it will fail silently if injection fails
    // always prefer constructor injection in your base code
    // for more information about inject strategies visit the official documentation:
    // http://site.mockito.org/mockito/docs/current/org/mockito/InjectMocks.html
    @InjectMocks private DiscountsService discountsServiceSUT;

    @Test
    public void testGetListOfDiscountsByHotel() {
        List<Float> returnPriceList = Arrays.asList(48847.98F, 8874.9F, 9887.07F);
        when(mockDiscountsPersistenceService.getListOfDiscountsByHotelId(HOTEL_ID)).thenReturn(
            returnPriceList);

        HotelDTO testHotel = new HotelDTO();
        testHotel.setHotelId(HOTEL_ID);
        List<Float> priceList = discountsServiceSUT.getListOfDiscountsByHotel(testHotel);
        assertThat(priceList, is(sameInstance(returnPriceList)));
    }

    @Test
    public void testFindSuiteRoomAvailability() {
        when(mockAvailabilityService.isRoomAvailable(anyObject())).thenReturn(false);
        boolean returnedAvailability = discountsServiceSUT.findSuiteRoomAvailability(ROOM_NAME);

        verify(mockAvailabilityService, times(1)).isRoomAvailable(anyObject());
        assertThat(returnedAvailability, is(false));
    }

    @Test
    public void testFindSuiteRoomAvailabilityWithCaptor() {
        ArgumentCaptor<RoomDTO> roomCaptor = ArgumentCaptor.forClass(RoomDTO.class);

        when(mockAvailabilityService.isRoomAvailable(roomCaptor.capture())).thenReturn(false);
        boolean returnedAvailability = discountsServiceSUT.findSuiteRoomAvailability(ROOM_NAME);

        assertThat(returnedAvailability, is(false));

        RoomDTO capturedRoom = roomCaptor.getValue();
        assertThat(capturedRoom.getRoomName(), is(ROOM_NAME));
        assertThat(capturedRoom.getRoomType(), is(RoomType.SUITE));
    }

    @Test
    public void testFindRoomWithGreaterDiscount() {
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                List<RoomDTO> passedList = (List<RoomDTO>) invocation.getArguments()[0];
                RoomDTO roomDTO1 = new RoomDTO();
                roomDTO1.setRoomType(RoomType.DOUBLE_ROOM);

                RoomDTO roomDTO2 = new RoomDTO();
                roomDTO2.setRoomType(RoomType.DUPLEX);
                passedList.add(roomDTO1);
                passedList.add(roomDTO2);

                return null;
            }
        }).when(mockRoomHelper).populateRoomList(anyList());

        RoomDTO returnedRoom = discountsServiceSUT.findRoomWithGreaterDiscount();
        assertThat(returnedRoom, is(notNullValue()));
        assertThat(returnedRoom.getRoomType(), is(RoomType.DOUBLE_ROOM.DOUBLE_ROOM));
    }
}
