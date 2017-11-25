package com.training.sample.day1109;

import com.training.sample.day1106.Car;
import com.training.sample.day1106.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SmartParkingBoyTest {
  @Test
  public void should_park_to_B_given_one_smart_parking_boy_2_parking_lot_A_capacity_1_B_capacity_2() throws Exception {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1, "A"), new ParkingLot(2, "B")));
    Car car = new Car();

    String licenceNumber = smartParkingBoy.parkingCar(car);

    String[] licences = licenceNumber.split("_");
    Assert.assertEquals("B", licences[0]);
  }

  @Test
  public void should_first_car_TO_park_A_Other_to_park_to_B_given_one_smart_parking_boy_2_parking_lot_A_capacity_2_B_capacity_2() throws Exception {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(2, "A"), new ParkingLot(2, "B")));
    Car car = new Car();
    Car car1 = new Car();
    String licenceNumber = smartParkingBoy.parkingCar(car);

    String secondLicenceNumber = smartParkingBoy.parkingCar(car1);

    String[] licences = licenceNumber.split("_");
    String[] licencesTwo = secondLicenceNumber.split("_");
    Assert.assertEquals("A", licences[0]);
    Assert.assertEquals("B", licencesTwo[0]);
  }

  @Test
  public void should_car_B_park_to_parking_lot_B_given_a_smart_parking_boy_2_parking_lot_A_capacity_is_1_B_capacity_is_2_first_car_carA_park_to_parking_lot_B_carA_pick_up() throws Exception {
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1, "A"), new ParkingLot(2, "B")));
    Car carA = new Car("CarA");
    String licenceNumber = smartParkingBoy.parkingCar(carA);
    smartParkingBoy.pickup(licenceNumber);
    Car carB = new Car("CarB");

    String licenceNumberB = smartParkingBoy.parkingCar(carB);

    String[] licenceInfos = licenceNumberB.split("_");
    Assert.assertEquals("B", licenceInfos[0]);
  }
}
