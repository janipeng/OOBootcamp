package com.training.sample.day1113;

import com.training.sample.day1106.Car;
import com.training.sample.day1106.ParkingLot;
import com.training.sample.day1116.ParkingAble;

import java.util.List;
import java.util.function.Function;

public class SuperParkingBoy extends ParkingAble {
  private List<ParkingLot> parkingLots;
  private ParkingStrategy parkingStrategy;

  public SuperParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
    createParkingStrategy();
  }

  private void createParkingStrategy() {
    parkingStrategy = new SuperParkingBoyParking(parkingLots);
  }

  @Override
  public String parkingCar(Car car) {
    ParkingLot parkingLot = parkingStrategy.getBestParkingLot();
    return parkingLot.parkingCar(car);
  }

  @Override
  public Car pickup(String licenceNum) {
    return parkingStrategy.pickup(parkingLots, licenceNum);
  }

  @Override
  protected List<ParkingLot> allParkingLots() {
    return this.parkingLots;
  }

  @Override
  public int parkedCount() {
    return parkingLots.stream()
            .map(parkingLot -> parkingLot.getParkingRecord().size())
            .reduce((a, b) -> a + b)
            .get();
  }

  @Override
  public int availableSpace() {
    return parkingLots.stream()
            .map(ParkingLot::getCapacityLeft)
            .reduce((a, b) -> a + b)
            .get();
  }

}
