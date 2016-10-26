package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.RoomDTO;
import gpotes.junitworkshop.model.RoomType;
import org.springframework.stereotype.Component;

@Component
class DiscountsService {
    /**
     * Contains all the logic to determine whether a {@code roomDTO} accepts discounts.
     *
     * @param roomDTO the roomDTO used to verify if accepts discounts
     *
     * @return true if accepts discounts, false otherwise
     */
    boolean acceptsDiscounts(final RoomDTO roomDTO) {
        return RoomType.SINGLE_ROOM.equals(roomDTO.getRoomType());
    }
}
