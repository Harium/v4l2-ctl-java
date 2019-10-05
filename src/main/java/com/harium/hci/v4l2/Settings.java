package com.harium.hci.v4l2;

import com.harium.hci.v4l2.params.Param;
import java.util.LinkedHashMap;
import java.util.Map;

public class Settings {

  public static final String PARAM_BRIGHTNESS = "brightness";
  public static final String PARAM_CONTRAST = "contrast";
  public static final String PARAM_SATURATION ="saturation";
  public static final String PARAM_HUE = "hue";
  public static final String PARAM_GAMMA = "gamma";
  public static final String PARAM_GAIN = "gain";
  public static final String PARAM_POWER_LINE_FREQUENCY = "power_line_frequency";
  public static final String PARAM_WHITE_BALANCE_TEMPERATURE = "white_balance_temperature";
  public static final String PARAM_WHITE_BALANCE_TEMPERATURE_AUTO = "white_balance_temperature_auto";
  public static final String PARAM_SHARPNESS = "sharpness";
  public static final String PARAM_BACKLIGHT_COMPENSATION = "backlight_compensation";
  public static final String PARAM_EXPOSURE_AUTO = "exposure_auto";
  public static final String PARAM_EXPOSURE_ABSOLUTE = "exposure_absolute";
  public static final String PARAM_EXPOSURE_AUTO_PRIORITY = "exposure_auto_priority";

  Map<String, Param> parameters = new LinkedHashMap<String, Param>();

  @Override
  public String toString() {
    final int alignment = 43;

    StringBuilder builder = new StringBuilder();
    for (Param param : parameters.values()) {
      String line = param.toString();

      int offset = line.indexOf("(");
      if (offset < alignment) {
        for (int i = 0; i < alignment - offset; i++) {
          builder.append(" ");
        }
      }
      builder.append(param);
      builder.append("\n");
    }
    return builder.toString();
  }

  public Param getBrightness() {
    return parameters.get(PARAM_BRIGHTNESS);
  }

  public Param getContrast() {
    return parameters.get(PARAM_CONTRAST);
  }

  public Param getHue() {
    return parameters.get(PARAM_HUE);
  }

  public Param getSaturation() {
    return parameters.get(PARAM_SATURATION);
  }

  public Param getGamma() {
    return parameters.get(PARAM_GAMMA);
  }

  public Param getGain() {
    return parameters.get(PARAM_GAIN);
  }

  public Param getSharpness() {
    return parameters.get(PARAM_SHARPNESS);
  }

  public Param getBacklightCompensation() {
    return parameters.get(PARAM_BACKLIGHT_COMPENSATION);
  }

  public Param getPowerLineFrequency() {
    return parameters.get(PARAM_POWER_LINE_FREQUENCY);
  }

  public Param getWhiteBalanceTemperature() {
    return parameters.get(PARAM_WHITE_BALANCE_TEMPERATURE);
  }

  public Param getWhiteBalanceTemperatureAuto() {
    return parameters.get(PARAM_WHITE_BALANCE_TEMPERATURE_AUTO);
  }

  public Param getExposureAuto() {
    return parameters.get(PARAM_EXPOSURE_AUTO);
  }

  public Param getExposureAutoPriority() {
    return parameters.get(PARAM_EXPOSURE_AUTO_PRIORITY);
  }

  public Param getExposureAbsolute() {
    return parameters.get(PARAM_EXPOSURE_ABSOLUTE);
  }

  public Param getParam(String param) {
    return parameters.get(param);
  }
}
