package com.training.sample.day1102;

import com.training.sample.day1102.LengthCompare;
import com.training.sample.day1102.UnitType;
import com.training.sample.day1102.Length;
import org.junit.Assert;
import org.junit.Test;

import static com.training.sample.day1102.LengthCompare.getTheBiggerLength;

public class LengthCompareTest {

  private LengthCompare lengthCompare = new LengthCompare();

  @Test
  public void testShouldGetTheBiggerLength() {
    int lenA = 5;
    int lenB = 10;
    Assert.assertEquals(lenB, getTheBiggerLength(lenA, lenB));
  }

  @Test
  public void testGetBiggerLengthWithoutUnit() throws Exception {
    Assert.assertEquals(lengthCompare.getBiggerOneWithoutUnit(100, 500), "500.0 is bigger. It is equals 5.0 times 100.0.");
    Assert.assertEquals(lengthCompare.getBiggerOneWithoutUnit(50, 5000), "5000.0 is bigger. It is equals 100.0 times 50.0.");
    Assert.assertEquals(lengthCompare.getBiggerOneWithoutUnit(50, 50), "They are equal.");
  }

  @Test
  public void testGetBiggerLengthWithUnitFormat() throws Exception {
    Length lenOne = new Length(100000d, UnitType.CM.name());
    Length lenTwo = new Length(5000d, UnitType.M.name());
    Length biggerOne = lengthCompare.getBiggerOneWithFormat(lenOne, lenTwo);
    Assert.assertEquals(biggerOne.getValue().compareTo(5d), 0);
    Assert.assertTrue(biggerOne.getUnit().equals(UnitType.KM.name()));
  }
}
