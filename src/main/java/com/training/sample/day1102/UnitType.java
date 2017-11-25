package com.training.sample.day1102;

public enum UnitType {
  KM(100000), M(100), CM(1);

  private int value;

  UnitType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static UnitType getUnitTypeByName(String unit) {
    for (UnitType unitType : UnitType.values()) {
      if (unitType.name().equals(unit)) {
        return unitType;
      }
    }
    return null;
  }
}
