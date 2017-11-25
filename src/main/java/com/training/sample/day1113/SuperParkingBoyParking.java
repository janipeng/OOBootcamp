package com.training.sample.day1113;

import com.training.sample.day1106.ParkingLot;

import java.util.List;

public class SuperParkingBoyParking extends ParkingStrategy {

  public SuperParkingBoyParking(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public ParkingLot getBestParkingLot() {
    ParkingLot lot = parkingLots.get(0);
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.getParkingLotPercentage() > lot.getParkingLotPercentage()) {
        lot = parkingLot;
      }
    }
    return lot;
  }
}
