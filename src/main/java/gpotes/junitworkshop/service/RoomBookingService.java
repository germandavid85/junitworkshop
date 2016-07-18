package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import gpotes.junitworkshop.model.RoomDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

class RoomBookingService implements IRoomBookingService {

    private final DiscountsService discountsService;

    @Autowired
    RoomBookingService(final DiscountsService discountsService) {
        this.discountsService = discountsService;
    }

    @Override
    public int getAvailableRoomsCount() {

        return 0;
    }

    @Override
    public boolean hasAvailableRooms(final HotelDTO hotelDTO) {
        Objects.requireNonNull(hotelDTO, "hotelDTO should be not null");

        return getAvailableRoomsCount() > 0;
    }

    @Override
    public List<RoomDTO> getBestPriceRooms(final HotelDTO hotelDTO) {
        List<RoomDTO> foundRooms;

        if (hotelDTO.getRoomList().size() < 0) {
            foundRooms = new ArrayList<>();
        } else {
            foundRooms = hotelDTO.getRoomList().stream()
                .filter(discountsService::acceptsDiscounts)
                .collect(Collectors.toList());
        }
        return foundRooms;
    }


}
