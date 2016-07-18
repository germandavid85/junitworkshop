package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.HotelDTO;
import gpotes.junitworkshop.model.RoomDTO;

import java.util.List;

public interface IRoomBookingService {

    int getAvailableRoomsCount();

    boolean hasAvailableRooms(HotelDTO hotelDTO);

    List<RoomDTO> getBestPriceRooms(HotelDTO hotelDTO);
}
