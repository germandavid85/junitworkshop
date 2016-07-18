package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import gpotes.junitworkshop.model.RoomDTO;
import gpotes.junitworkshop.model.RoomType;
import gpotes.junitworkshop.persistence.DiscountsPersistenceService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiscountsService {

    private DiscountsPersistenceService discountsPersistenceService = new DiscountsPersistenceService();
    private AvailabilityService availabilityService = new AvailabilityService();
    private RoomHelper roomHelper = new RoomHelper();

    /**
     * Contains all the logic to determine whether a {@code roomDTO} accepts discounts. This will call another
     * services and legacy code. Also will fire some database queries to obtains the results.
     *
     * @param roomDTO the roomDTO used to verify if accepts discounts
     *
     * @return true if accepts discounts, false otherwise
     */
    boolean acceptsDiscounts(final RoomDTO roomDTO) {

        // this will call a lot of other services and will dispatch database queries to obtain the data
        return false;
    }

    List<Float> getListOfDiscountsByHotel(final HotelDTO hotelDTO) {
        return discountsPersistenceService.getListOfDiscountsByHotelId(hotelDTO.getHotelId());
    }

    boolean findSuiteRoomAvailability(final String roomName) {
        RoomDTO suiteRoom = new RoomDTO();
        suiteRoom.setRoomType(RoomType.SUITE);
        suiteRoom.setRoomName(roomName);

        return availabilityService.isRoomAvailable(suiteRoom);
    }

    RoomDTO findRoomWithGreaterDiscount() {
        List<RoomDTO> allRooms = new ArrayList<>();
        roomHelper.populateRoomList(allRooms);

        return allRooms.get(0);
    }


}
