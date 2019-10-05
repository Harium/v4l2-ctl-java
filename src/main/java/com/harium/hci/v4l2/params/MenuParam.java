package com.harium.hci.v4l2.params;

public class MenuParam extends Param {

  public MenuParam() {
    name = Param.MENU;
  }

  @Override
  public String toString() {
    return prefixString() + "   : min=" + min + " max=" + max
        + " default=" + defaultValue + " value=" + value;
  }

}
