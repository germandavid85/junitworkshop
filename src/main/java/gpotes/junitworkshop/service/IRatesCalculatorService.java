package gpotes.junitworkshop.service;

import gpotes.junitworkshop.model.RoomDTO;

public interface IRatesCalculatorService {
    long calculateRate(RoomDTO roomDTO);
    double calculateAdditionalDiscount(long currentRate);
}
