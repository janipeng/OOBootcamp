package com.training.sample.day1116;

import com.training.sample.day1106.Car;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ParkingLotManager {
  private ParkingAble[] parkingAbleList;

  public ParkingLotManager(ParkingAble... parkingAble) {
    parkingAbleList = parkingAble;
  }

  String park(Car car) {
    Optional<String> licence = Arrays.stream(parkingAbleList)
            .map(lot -> lot.parkingCar(car))
            .filter(Objects::nonNull)
            .findFirst();
    return licence.orElse("");
  }

  public Car pickup(String licence) {
    Optional<Car> car = Arrays.stream(parkingAbleList)
            .map(lot -> lot.pickup(licence))
            .filter(Objects::nonNull)
            .findFirst();
    return car.orElse(null);
  }

  public String report2() {

    ParkingAble parkingAble = parkingAbleList[0];
    int parkedCount = parkingAble.parkedCount();
    int availableSpace = parkingAble.availableSpace();
    return reportsFormat(parkedCount, availableSpace);
  }

  public String report() {
    int parkedCount = 0;
    int availableSpace = 0;
    StringBuffer subReports = new StringBuffer();
    for (ParkingAble parkingAble : parkingAbleList) {
      parkedCount += parkingAble.parkedCount();
      availableSpace += parkingAble.availableSpace();
      subReports.append("\n").append(parkingAble.report());
    }
    return reportsFormat(parkedCount, availableSpace) + subReports;
  }

  private String reportsFormat(int parkedCount, int availableSpace) {

    return new StringBuffer().append("M")
            .append(" ")
            .append(parkedCount)
            .append(" ")
            .append(availableSpace)
            .toString();
  }
}
