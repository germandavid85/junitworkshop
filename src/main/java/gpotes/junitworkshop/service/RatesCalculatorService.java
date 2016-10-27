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

    @Override
    public double calculateAdditionalDiscount(long currentRate) {
        double additionalDiscount = 0D;

        if (currentRate > 100 && currentRate < 600) {
            additionalDiscount = currentRate * 0.05;
        }

        else if (currentRate >= 600 && currentRate < 1500) {
            additionalDiscount = currentRate * 0.06;
        }

        else if (currentRate >= 1500 && currentRate < 3000) {
            additionalDiscount = currentRate * 0.07;
        }

        else if (currentRate >= 3000 && currentRate <= 5000) {
            additionalDiscount = currentRate * 0.08;
        }

        else if (currentRate >= 5000) {
            additionalDiscount = currentRate * 0.1;
        }

        return additionalDiscount;
    }


}
