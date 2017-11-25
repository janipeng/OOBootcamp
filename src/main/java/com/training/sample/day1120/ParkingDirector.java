package com.training.sample.day1120;

import com.training.sample.day1116.ParkingLotManager;

public class ParkingDirector {
  private ParkingLotManager manager;

  public ParkingDirector(ParkingLotManager manager) {

    this.manager = manager;
  }

  public String report() {
    return manager.report();
  }
}
