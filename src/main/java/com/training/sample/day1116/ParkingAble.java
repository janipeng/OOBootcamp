package com.training.sample.day1116;

import com.training.sample.day1106.Car;
import com.training.sample.day1106.ParkingLot;

import java.util.List;

public abstract class ParkingAble {

  protected abstract String parkingCar(Car car);

  protected abstract Car pickup(String licenceNumber);

  public String report() {
    int parkedCount = 0;
    int available = 0;
    StringBuffer parkingLotReport = new StringBuffer();
    for (ParkingLot parkingLot : allParkingLots()) {
      parkedCount += parkingLot.getParkingRecord().size();
      available += parkingLot.getCapacityLeft();
      parkingLotReport.append(formatParkingLotReport(parkingLot));
    }
    return reportFormat(parkedCount, available) + parkingLotReport;
  }

  private StringBuffer formatParkingLotReport(ParkingLot parkingLot) {
    return new StringBuffer()
            .append("\n")
            .append(" ")
            .append(parkingLot.report());
  }

  private String reportFormat(int parkedCount, int available) {
    return new StringBuffer(" B ")
            .append(parkedCount)
            .append(" ")
            .append(available)
            .toString();
  }

  protected abstract List<ParkingLot> allParkingLots();

  protected abstract int parkedCount();

  protected abstract int availableSpace();
}
