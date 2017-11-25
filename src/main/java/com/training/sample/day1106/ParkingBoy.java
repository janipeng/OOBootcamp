package com.training.sample.day1106;

import com.training.sample.day1113.ParkingStrategy;
import com.training.sample.day1116.ParkingAble;

import java.util.List;

public class ParkingBoy extends ParkingAble {

  private List<ParkingLot> parkingLots;
  private ParkingStrategy parkingStrategy;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
    createParkingStrategy();
  }

  private void createParkingStrategy() {
    parkingStrategy = new ParkingBoyParking(parkingLots);
  }

  public String parkingCar(Car car) {
    ParkingLot parkingLot = parkingStrategy.getBestParkingLot();
    return parkingLot.parkingCar(car);
  }

  public Car pickup(String licenceNumber) {
    return parkingStrategy.pickup(parkingLots, licenceNumber);
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
