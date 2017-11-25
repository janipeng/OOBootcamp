package com.training.sample.day1113;

import com.training.sample.day1106.Car;
import com.training.sample.day1106.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SuperParkingBoyTest {
  @Test
  public void should_park_to_higher_space_percentage_parking_lot() throws Exception {
    ParkingLot parkingLotA = new ParkingLot(2, "A");
    ParkingLot parkingLotB = new ParkingLot(1, "B");
    SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLotA, parkingLotB));
    Car car1 = new Car();
    parkingLotA.parkingCar(car1);
    Car car2 = new Car();

    String licenceNumber = superParkingBoy.parkingCar(car2);

    String[] licenceInfo = licenceNumber.split("_");
    Assert.assertEquals("B", licenceInfo[0]);
  }

  @Test
  public void should_park_to_higher_space_percentage_parking_lot_and_has_pick_car() throws Exception {
    ParkingLot parkingLotA = new ParkingLot(2, "A");
    SuperParkingBoy superParkingBoy = new SuperParkingBoy(Arrays.asList(parkingLotA));
    Car car1 = new Car();
    Car car2 = new Car();
    String parkLicenceNum = parkingLotA.parkingCar(car1);
    superParkingBoy.pickup(parkLicenceNum);

    String licenceNumber = superParkingBoy.parkingCar(car2);

    String[] licenceInfo = licenceNumber.split("_");
    Assert.assertEquals("A", licenceInfo[0]);
  }
}
