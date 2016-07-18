package gpotes.junitworkshop.persistence;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Connection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PersistenceUtil.class, HotelBuilder.class})
public class EDiscountsPersistenceServiceTestWithPowerMock {
    private static final String HOTEL_NAME = "Calixo";

    @Mock private HotelBuilder mockHotelBuilder;
    @InjectMocks private DiscountsPersistenceService testService;

    @Before
    public void initialSetup() {
        // mock instance injected with InjectMocks and final class mocked with
        // PowerMockito constructor mock
        Hotel testHotel = new Hotel();
        testHotel.setHotelName(HOTEL_NAME);

        when(mockHotelBuilder.build()).thenReturn(testHotel);
        when(mockHotelBuilder.setHotelId(anyLong())).thenReturn(mockHotelBuilder);
        when(mockHotelBuilder.setHotelName(anyString())).thenReturn(mockHotelBuilder);

        try {
            PowerMockito.whenNew(HotelBuilder.class).withNoArguments().thenReturn(mockHotelBuilder);
        } catch (Exception exception) {
            fail("Failed HotelBuilder constructor mock");
        }
    }

    @Test
    public void testGetDBConnection() {
        PowerMockito.mockStatic(PersistenceUtil.class);

        Connection mockConnection = mock(Connection.class);
        when(PersistenceUtil.getDBConnection()).thenReturn(mockConnection);

        List<Float> returnedDiscounts = testService.getListOfDiscountsByHotelId(689L);
        assertThat(returnedDiscounts.isEmpty(), is(true));
    }

    @Test
    public void testGetAllExistingHotels() {

        List<Hotel> allHotels = testService.getAllExistingHotels();
        assertThat(allHotels.size(), is(1));
        assertThat(allHotels.get(0).getHotelName(), is(HOTEL_NAME));
    }
}
