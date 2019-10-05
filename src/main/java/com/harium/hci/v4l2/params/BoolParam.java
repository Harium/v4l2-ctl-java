package com.harium.hci.v4l2.params;

public class BoolParam extends Param {

  public BoolParam() {
    type = Param.BOOL;
  }

  public void setValue(boolean value) {
    this.value = value ? "1" : "0";
  }

  @Override
  public String toString() {
    return prefixString() + "   : default=" + defaultValue + " value=" + value;
  }
}
