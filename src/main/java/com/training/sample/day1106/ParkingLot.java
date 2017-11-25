package com.training.sample.day1106;

import com.training.sample.day1116.ParkingAble;

import java.util.*;

public class ParkingLot extends ParkingAble {
  private int capacityLeft;
  private String name;
  private Map<String, Car> parkingRecord = new HashMap<String, Car>();

  public ParkingLot(int capacity, String name) {
    this.capacityLeft = capacity;
    this.name = name;
  }

  public ParkingLot(int capacity) {
    this.capacityLeft = capacity;
  }

  @Override
  public String parkingCar(Car car) {
    if (capacityLeft > 0) {
      String licenceNumber = getLicenceNumber();
      parkingRecord.put(licenceNumber, car);
      capacityLeft--;
      return licenceNumber;
    }
    return null;
  }

  private String getLicenceNumber() {
    return name + "_" + UUID.randomUUID().toString().replaceAll("_", "");
  }

  @Override
  public Car pickup(String licenceNumber) {
    if (this.parkingRecord.containsKey(licenceNumber)) {
      Car car = this.parkingRecord.get(licenceNumber);
      this.parkingRecord.remove(car);
      this.capacityLeft++;
      return car;
    }
    return null;
  }

  @Override
  public String report() {
    StringBuffer reports = new StringBuffer();
    return reports
            .append(" P ")
            .append(parkingRecord.size())
            .append(" ")
            .append(capacityLeft)
            .toString();
  }

  @Override
  protected List<ParkingLot> allParkingLots() {
    return Collections.singletonList(this);
  }

  @Override
  public int parkedCount() {
    return this.getParkingRecord().size();
  }

  @Override
  public int availableSpace() {
    return this.getCapacityLeft();
  }

  public Map<String, Car> getParkingRecord() {
    return parkingRecord;
  }

  public int getCapacityLeft() {
    return capacityLeft;
  }


  public double getParkingLotPercentage() {
    return (getCapacityLeft() * 1.0) / (getCapacityLeft() + getParkingRecord().size());
  }

}
