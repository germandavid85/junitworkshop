package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.RoomDTO;
import gpotes.junitworkshop.model.RoomType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RatesCalculatorServiceTest {
    private IRatesCalculatorService sut = new RatesCalculatorService();
    private final RoomDTO actualRoomDTO;
    private final long expectedRate;

    public RatesCalculatorServiceTest(final RoomDTO actualRoomDTO, final long expectedRate) {
        this.actualRoomDTO = actualRoomDTO;
        this.expectedRate = expectedRate;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        RoomDTO room1 = new RoomDTO();
        room1.setRoomType(RoomType.SINGLE_ROOM);

        RoomDTO room2 = new RoomDTO();
        room2.setRoomType(RoomType.SUITE);


        return Arrays.asList(new Object[][] {
            { room1, 670L },
            { room2, 5000L }
        });
    }

    @Test
    public void calculateRatesTest() {
        assertThat(sut.calculateRate(this.actualRoomDTO), is(this.expectedRate));
    }
}
