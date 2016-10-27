package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import gpotes.junitworkshop.model.RoomDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

class RoomBookingService implements IRoomBookingService {

    private final DiscountsService discountsService;

    @Autowired
    RoomBookingService(final DiscountsService discountsService) {
        Objects.requireNonNull(discountsService, "null discountsService");
        this.discountsService = discountsService;
    }

    @Override
    public int getAvailableRoomsCount() {
        return 4;
    }

    @Override
    public boolean hasAvailableRooms(final HotelDTO hotelDTO) {
        Objects.requireNonNull(hotelDTO, "hotelDTO should be not null");

        return getAvailableRoomsCount() > 0;
    }

    @Override
    public List<RoomDTO> getBestPriceRooms(final HotelDTO hotelDTO) {
        Objects.requireNonNull(hotelDTO, "invalid hotelDTO");

        return hotelDTO.getRoomList().stream()
            .filter(discountsService::acceptsDiscounts)
            .collect(Collectors.toList());
    }
}
