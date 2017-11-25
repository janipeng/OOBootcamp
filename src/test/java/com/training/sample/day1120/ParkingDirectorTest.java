package com.training.sample.day1120;

import com.training.sample.day1106.Car;
import com.training.sample.day1106.ParkingBoy;
import com.training.sample.day1106.ParkingLot;
import com.training.sample.day1109.SmartParkingBoy;
import com.training.sample.day1113.SuperParkingBoy;
import com.training.sample.day1116.ParkingLotManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ParkingDirectorTest {

  @Test
  public void given_1_parking_director_1_parking_manager_1_parking_lot_A_capacity_2_and_parked_1_car() throws Exception {
    ParkingLot lotA = new ParkingLot(2, "A");
    lotA.parkingCar(new Car());
    ParkingDirector director = new ParkingDirector(new ParkingLotManager(lotA));

    String reports = director.report();

    Assert.assertEquals("M 1 1\n P 1 1", reports);
  }

  @Test
  public void given_1_parking_director_1_parking_manager_with_1_parking_lot_A_capacity_is_2_parked_1_car_1_parking_boy_with_1_parking_lot_B_capacity_is_2_and_parked_1_car() throws Exception {
    ParkingLot lotA = new ParkingLot(2, "A");
    lotA.parkingCar(new Car());
    ParkingLot lotB = new ParkingLot(2, "B");
    lotB.parkingCar(new Car());
    ParkingDirector director = new ParkingDirector(new ParkingLotManager(lotA, new ParkingBoy(Collections.singletonList(lotB))));

    String reports = director.report();

    Assert.assertEquals("M 2 2\n P 1 1\n B 1 1\n  P 1 1", reports);
  }

  @Test
  public void given_1_director_1_manager_with_1_packing_lot_capacity_is_2_parked_1_car_1_parking_boy_with_1_lot_capacity_is_2_parked_1_car_1_smart_parking_boy_with_1_lot_capacity_is_1() throws Exception {
    ParkingLot lotA = new ParkingLot(2, "A");
    lotA.parkingCar(new Car());
    ParkingLot lotB = new ParkingLot(2, "B");
    lotB.parkingCar(new Car());
    ParkingDirector director =
            new ParkingDirector(
                    new ParkingLotManager(
                            lotA,
                            new ParkingBoy(Collections.singletonList(lotB)),
                            new SmartParkingBoy(Collections.singletonList(new ParkingLot(1, "C")))
                    )
            );

    String reports = director.report();

    Assert.assertEquals("M 2 3\n" +
            " P 1 1\n" +
            " B 1 1\n" +
            "  P 1 1\n" +
            " B 0 1\n" +
            "  P 0 1", reports);
  }

  @Test
  public void given_1_director_1_manager_with_1_packing_lot_capacity_is_2_parked_1_car_1_parking_boy_with_1_lot_capacity_is_2_parked_1_car_1_smart_parking_boy_with_1_lot_capacity_is_1_1_super_parking_lot_capacity_1() throws Exception {
    ParkingLot lotA = new ParkingLot(2, "A");
    lotA.parkingCar(new Car());
    ParkingLot lotB = new ParkingLot(2, "B");
    lotB.parkingCar(new Car());
    ParkingDirector director =
            new ParkingDirector(
                    new ParkingLotManager(
                            lotA,
                            new ParkingBoy(Collections.singletonList(lotB)),
                            new SmartParkingBoy(Collections.singletonList(new ParkingLot(1, "C"))),
                            new SuperParkingBoy(Collections.singletonList(new ParkingLot(1, "D")))
                    )
            );

    String reports = director.report();

    Assert.assertEquals("M 2 4\n" +
            " P 1 1\n" +
            " B 1 1\n" +
            "  P 1 1\n" +
            " B 0 1\n" +
            "  P 0 1\n" +
            " B 0 1\n" +
            "  P 0 1", reports);
  }


  @Test
  public void test_final_reports() throws Exception {
    ParkingLot lotA = new ParkingLot(2, "A");
    lotA.parkingCar(new Car());
    ParkingLot lotB = new ParkingLot(2, "B");
    lotB.parkingCar(new Car());
    ParkingLot lotE = new ParkingLot(1, "E");
    lotE.parkingCar(new Car());
    ParkingDirector director =
            new ParkingDirector(
                    new ParkingLotManager(
                            lotA,
                            new ParkingBoy(Collections.singletonList(lotB)),
                            new SmartParkingBoy(Collections.singletonList(new ParkingLot(1, "C"))),
                            new SuperParkingBoy(Arrays.asList(new ParkingLot(1, "D"), lotE))
                    )
            );

    String reports = director.report();

    Assert.assertEquals("M 3 4\n" +
            " P 1 1\n" +
            " B 1 1\n" +
            "  P 1 1\n" +
            " B 0 1\n" +
            "  P 0 1\n" +
            " B 1 1\n" +
            "  P 0 1\n" +
            "  P 1 0", reports);
  }
}
