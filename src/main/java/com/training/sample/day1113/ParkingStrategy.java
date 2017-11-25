package com.training.sample.day1113;

import com.training.sample.day1106.Car;
import com.training.sample.day1106.ParkingLot;
import com.training.sample.day1116.ParkingAble;

import java.util.List;

public abstract class ParkingStrategy {

  protected List<ParkingLot> parkingLots;

  public ParkingStrategy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public abstract ParkingLot getBestParkingLot();

  public Car pickup(List<ParkingLot> parkingLots, String licenceNum) {
    for (ParkingLot parkingLot : parkingLots) {
      Car car = parkingLot.pickup(licenceNum);
      if (car != null) {
        return car;
      }
    }
    return null;
  }
}
