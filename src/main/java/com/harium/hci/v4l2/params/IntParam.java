package com.harium.hci.v4l2.params;

public class IntParam extends Param {

  /*int minValue;
  int maxValue;
  int step;
  int defaultValue;
  int value;*/

  public IntParam() {
    type = Param.INT;
  }

  @Override
  public String toString() {
    String text = prefixString() + "    : min=" + min + " max=" + max + " step="
        + step + " default=" + defaultValue + " value=" + value;

    if (!flags.isEmpty()) {
      text += " flags=" + flags;
    }

    return text;
  }

}
