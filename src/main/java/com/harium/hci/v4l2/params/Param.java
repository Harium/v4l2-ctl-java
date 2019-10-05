package com.harium.hci.v4l2.params;

public class Param {

  public static final String BOOL = "bool";
  public static final String INT = "int";
  public static final String MENU = "menu";

  String name = "";
  String address = "";
  String type = "";

  String min = "";
  String max = "";
  String step = "";
  String defaultValue = "";
  String value = "";
  String flags = "";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void resetValue() {
    this.value = defaultValue;
  }

  public String getMin() {
    return min;
  }

  public void setMin(String min) {
    this.min = min;
  }

  public String getMax() {
    return max;
  }

  public void setMax(String max) {
    this.max = max;
  }

  public String getStep() {
    return step;
  }

  public void setStep(String step) {
    this.step = step;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getFlags() {
    return flags;
  }

  public void setFlags(String flags) {
    this.flags = flags;
  }

  protected String prefixString() {
    String common = name + " " + address + " (" + type + ")";
    return common;
  }

}
