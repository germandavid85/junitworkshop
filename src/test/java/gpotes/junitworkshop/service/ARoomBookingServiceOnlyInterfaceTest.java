package gpotes.junitworkshop.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;

/**
 * This test class contains:
 *   - Simple use of mocking
 *   - Simple use of TestName rule
 */
public class ARoomBookingServiceOnlyInterfaceTest {

    @Rule public TestName testName = new TestName();

    private IRoomBookingService serviceSUT;

    @Before
    public void setup() {

        serviceSUT = mock(IRoomBookingService.class);
    }

    @Test
    public void fullAvailabilityThenIShouldHave8AvailableRooms() {

        assertEquals("Invalid available rooms count" + testName, 8, serviceSUT.getAvailableRoomsCount());
    }

    @Test
    public void fullAvailabilityThenIShouldHave8AvailableRoomsWithMatcher() {

        assertThat(serviceSUT.getAvailableRoomsCount(), is(8));
    }

    @Test
    public void noAvailabilityThenIShouldHave0AvailableRooms() {

        assertEquals("Invalid available rooms count", 0, serviceSUT.getAvailableRoomsCount());
    }
}
