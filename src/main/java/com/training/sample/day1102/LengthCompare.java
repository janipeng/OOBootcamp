package com.training.sample.day1102;

public class LengthCompare {

  public static int getTheBiggerLength(int lenA, int lenB) {
    return lenA > lenB ? lenA : lenB;
  }

  public Length getBiggerOneWithFormat(Length lenOne, Length lenTwo) {
    Length bigger = lenOne.compareTo(lenTwo) == 1 ? lenOne : lenTwo;
    UnitType unitType = UnitType.getUnitTypeByName(bigger.getUnit());
    bigger.setValue(bigger.getValue() * unitType.getValue() / UnitType.KM.getValue());
    bigger.setUnit(UnitType.KM.name());
    return bigger;
  }

  public String getBiggerOneWithoutUnit(double value1, double value2) {
    if (value1 > value2) {
      return getCompareResult(value1, value2);
    } else if (value1 < value2) {
      return getCompareResult(value2, value1);
    }
    return "They are equal.";
  }

  private String getCompareResult(double bigger, double smaller) {
    StringBuffer buffer = new StringBuffer();
    return buffer.append(bigger).append(" is bigger. It is equals ").append(bigger / smaller).append(" times ").append(smaller).append(".").toString();
  }
}
