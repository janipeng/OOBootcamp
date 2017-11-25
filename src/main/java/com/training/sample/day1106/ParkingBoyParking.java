package com.training.sample.day1106;

import com.training.sample.day1113.ParkingStrategy;

import java.util.List;

public class ParkingBoyParking extends ParkingStrategy {

  public ParkingBoyParking(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public ParkingLot getBestParkingLot() {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.getCapacityLeft() > 0) {
        return parkingLot;
      }
    }
    return parkingLots.get(0);
  }
}
