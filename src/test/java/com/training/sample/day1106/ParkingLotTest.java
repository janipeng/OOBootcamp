package com.training.sample.day1106;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ParkingLotTest {

  @Test
  public void testParkCarSuccess() {
    ParkingLot parkingLot = new ParkingLot(2);
    Car car = new Car();

    String parkingLicenceNumber = parkingLot.parkingCar(car);


    Assert.assertTrue(isNotEmpty(parkingLicenceNumber));
  }

  @Test
  public void testTakeCarSuccess() throws Exception {
    ParkingLot parkingLot = new ParkingLot(2);
    Car car = new Car();
    String licenceNumber = parkingLot.parkingCar(car);

    Car takingCar = parkingLot.pickup(licenceNumber);

    Assert.assertSame(car, takingCar);
  }

  @Test
  public void testTakeCarWithCorrectLicenceNumber() throws Exception {
    ParkingLot parkingLot = new ParkingLot(10);
    Car car = new Car();
    String parkingLicenceNumber = parkingLot.parkingCar(car);

    Car takingCar = parkingLot.pickup(parkingLicenceNumber);

    Assert.assertSame(car, takingCar);
  }

  @Test
  public void should_parking_success_when_1_parking_boy_1_parking_lot_1_car_to_park_This_parking_lot_is_not_full() throws Exception {
    ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(2)));
    Car car = new Car();

    String licenceNumber = parkingBoy.parkingCar(car);

    Assert.assertTrue(isNotEmpty(licenceNumber));
  }

  @Test
  public void should_parking_success_when_1_parking_boy_2_parking_lot_1_car_to_park_No_1_parking_lot_is_not_full() throws Exception {
    ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(2), new ParkingLot(2)));
    Car car = new Car();

    String licenceNumber = parkingBoy.parkingCar(car);

    Assert.assertTrue(isNotEmpty(licenceNumber));
  }

  @Test
  public void should_parking_fail_given_1_parking_boy_2_parking_lot_1_car_to_park_No_1_and_No_2_parking_lot_are_full() throws Exception {
    ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));
    Car car = new Car();

    String licenceNumber = parkingBoy.parkingCar(car);

    Assert.assertFalse(isNotEmpty(licenceNumber));
  }

  @Test
  public void should_parking_to_No_2_parking_lot_given_1_parking_boy_2_parking_lot_1_car_to_park_No_1_parking_lot_is_full_but_No_2_is_not_full() throws Exception {
    ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(2)));
    Car car = new Car();

    String licenceNumber = parkingBoy.parkingCar(car);

    Assert.assertTrue(isNotEmpty(licenceNumber));
  }

  @Test
  public void should_parking_to_No_1_parking_lot_given_1_parking_boy_2_parking_lot_1_car_to_park_No_1_parking_lot_is_full_but_Someone_Pick_Up_One_Car_From_No_1_Parking_Lot() throws Exception {
    ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot(2)));
    Car car = new Car();
    String licenceNumber = parkingBoy.parkingCar(car);

    Car pickUpCar = parkingBoy.pickup(licenceNumber);

    Assert.assertSame(car, pickUpCar);
  }

  private boolean isNotEmpty(String licenceNumber) {
    return licenceNumber != null && !"".equals(licenceNumber);
  }
}
