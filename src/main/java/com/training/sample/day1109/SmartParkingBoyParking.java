package com.training.sample.day1109;

import com.training.sample.day1106.ParkingLot;
import com.training.sample.day1113.ParkingStrategy;

import java.util.List;

public class SmartParkingBoyParking extends ParkingStrategy {
  public SmartParkingBoyParking(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  public ParkingLot getBestParkingLot() {
    ParkingLot parkingLot = parkingLots.get(0);
    for (ParkingLot lot : parkingLots) {
      if (lot.getCapacityLeft() > parkingLot.getCapacityLeft()) {
        parkingLot = lot;
      }
    }
    return parkingLot;
  }
}
