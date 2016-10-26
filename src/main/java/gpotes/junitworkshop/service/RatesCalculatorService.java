package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.RoomDTO;

import java.util.Objects;

class RatesCalculatorService implements IRatesCalculatorService {
    @Override
    public long calculateRate(final RoomDTO roomDTO) {
        Objects.requireNonNull(roomDTO, "null roomDTO");

        long rate;
        switch (roomDTO.getRoomType()) {
            case DOUBLE_ROOM:
                rate = 1000;
                break;
            case DUPLEX:
                rate = 1500;
                break;
            case SUITE:
                rate = 5000;
                break;
            case SINGLE_ROOM:
                rate = 670;
                break;
            default:
                rate = 800;
                break;
        }
        return rate;
    }
}
