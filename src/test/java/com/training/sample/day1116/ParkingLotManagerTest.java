package com.training.sample.day1116;

import com.training.sample.day1106.Car;
import com.training.sample.day1106.ParkingBoy;
import com.training.sample.day1106.ParkingLot;
import com.training.sample.day1109.SmartParkingBoy;
import com.training.sample.day1113.SuperParkingBoy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertSame;

public class ParkingLotManagerTest {
  @Test
  public void should_park_given_a_parking_manager_1_parking_lot() throws Exception {
    ParkingLot parkingLot = new ParkingLot(2, "A");
    ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
    Car car = new Car();

    String parkLicenceNum = parkingLotManager.park(car);

    Assert.assertTrue(parkLicenceNum != null && !"".equals(parkLicenceNum));
  }

  @Test
  public void should_pick_given_a_parking_manager_1_parking_lot() throws Exception {
    ParkingLot parkingLot = new ParkingLot(2, "A");
    ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLot);
    Car car = new Car();
    String parkLicenceNum = parkingLotManager.park(car);

    Car pickCar = parkingLotManager.pickup(parkLicenceNum);

    assertSame(pickCar, car);
  }

  @Test
  public void should_park_by_parking_boy_given_a_parking_manager_1_parking_lot_1_car_to_park() throws Exception {
    ParkingLot parkingLot = new ParkingLot(2, "A");
    ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));
    ParkingLotManager parkingLotManager = new ParkingLotManager(parkingBoy);
    Car car = new Car();
    String parkLicenceNum = parkingLotManager.park(car);

    Car pickCar = parkingLotManager.pickup(parkLicenceNum);

    assertSame(pickCar, car);
  }

  @Test
  public void should_park_by_smart_parking_boy_given_a_parking_manager_1_parking_lot_1_car_to_park() throws Exception {
    ParkingLot parkingLot = new ParkingLot(2, "A");
    SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot));
    ParkingLotManager parkingLotManager = new ParkingLotManager(parkingBoy);
    Car car = new Car();
    String parkLicenceNum = parkingLotManager.park(car);

    Car pickCar = parkingLotManager.pickup(parkLicenceNum);

    assertSame(pickCar, car);
  }
  @Test
  public void should_park_by_super_parking_boy_given_a_parking_manager_1_parking_lot_1_car_to_park() throws Exception {
    ParkingLot parkingLot = new ParkingLot(2, "A");
    SuperParkingBoy parkingBoy = new SuperParkingBoy(Arrays.asList(parkingLot));
    ParkingLotManager parkingLotManager = new ParkingLotManager(parkingBoy);
    Car car = new Car();
    String parkLicenceNum = parkingLotManager.park(car);

    Car pickCar = parkingLotManager.pickup(parkLicenceNum);

    assertSame(pickCar, car);
  }

  @Test
  public void should_park_and_pickup_success_given_1_parking_lot_manager_2_parking_lot_with_1_capacity_1_normal_1_smart_1_super_parking_boy_2_car_to_park() throws Exception {
    ParkingLot lotA = new ParkingLot(1, "A");
    ParkingLot lotB = new ParkingLot(1, "B");
    ParkingBoy normalBoy = new ParkingBoy(Arrays.asList(lotA, lotB));
    SmartParkingBoy smartBoy = new SmartParkingBoy(Arrays.asList(lotA, lotB));
    SuperParkingBoy superBoy = new SuperParkingBoy(Arrays.asList(lotA, lotB));
    ParkingLotManager manager = new ParkingLotManager(lotA, lotB, normalBoy, smartBoy, superBoy);
    Car carA = new Car();
    Car carB = new Car();

    String licenceA = manager.park(carA);
    String licenceB = manager.park(carB);

    assertSame(carA, manager.pickup(licenceA));
    assertSame(carB, manager.pickup(licenceB));
  }
}