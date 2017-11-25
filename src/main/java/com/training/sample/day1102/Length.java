package com.training.sample.day1102;

public class Length {

  private Double value;
  private String unit;

  public Length(Double value, String unit) {
    this.value = value;
    this.unit = unit;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public int compareTo(Length lenTwo) {
    Double thisValue = 0d;
    Double compareValue = 0d;
    for (UnitType unitType : UnitType.values()) {
      if (unitType.name().equals(this.unit)) {
        thisValue = this.value * unitType.getValue();
      }
      if (unitType.name().equals(lenTwo.getUnit())) {
        compareValue = lenTwo.getValue() * unitType.getValue();
      }
    }
    return thisValue.compareTo(compareValue);
  }
}
