package com.harium.hci.v4l2;

import com.harium.hci.v4l2.params.Param;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class V4L2Ctl {

  public static final String COMMAND_V4L2_CTL = "v4l2-ctl";
  public static final String PARAM_DEVICE = "-d";
  public static final String PARAM_LIST = "-l";
  public static final String PARAM_LONG_SET_CTRL = "--set-ctrl=";

  /**
   * List all v4l2-ctl settings from default device
   */
  public static Settings getSettings() {
    ProcessBuilder builder = new ProcessBuilder(COMMAND_V4L2_CTL, PARAM_LIST);
    builder.redirectErrorStream(true);
    try {
      Process process = builder.start();
      InputStream stdout = process.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
      Settings settings = parseParams(reader);
      return settings;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new Settings();
  }

  /**
   * List all v4l2-ctl settings from specific device
   */
  public static Settings getSettings(String device) {
    ProcessBuilder builder = new ProcessBuilder(COMMAND_V4L2_CTL, PARAM_DEVICE, device, PARAM_LIST);
    builder.redirectErrorStream(true);
    try {
      Process process = builder.start();
      InputStream stdout = process.getInputStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
      Settings settings = parseParams(reader);
      return settings;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return new Settings();
  }

  private static Settings parseParams(BufferedReader reader) throws IOException {
    Settings settings = new Settings();

    String line;
    while ((line = reader.readLine()) != null) {
      Parser.parseLine(settings, line);
    }
    return settings;
  }

  /**
   * Reset all params to default
   */
  public static void reset() {
    Settings settings = getSettings();
    for (Param param : settings.parameters.values()) {
      param.resetValue();
    }
    update(settings);
  }

  /**
   * Reset all params to default
   */
  public static void reset(String device) {
    Settings settings = getSettings();
    for (Param param : settings.parameters.values()) {
      param.resetValue();
    }
    update(device, settings);
  }

  /**
   * Update all settings based on current values
   *
   * @param settings
   */
  public static void update(Settings settings) {
    List<String> commandList = buildUpdateCommand(settings);
    String[] commands = commandList.toArray(new String[commandList.size()]);

    executeSync(commands);
  }

  /**
   * Update custom param
   *
   * @param param
   * @param value
   */
  public static void update(String param, String value) {
    String[] commands = new String[]{COMMAND_V4L2_CTL, PARAM_LONG_SET_CTRL + param + "=" + value};
    executeSync(commands);
  }

  /**
   * Update custom param
   *
   * @param param
   * @param value
   */
  public static void update(String param, int value) {
    update(param, Integer.toString(value));
  }

  /**
   * Update custom param
   *
   * @param device
   * @param param
   * @param value
   */
  public static void update(String device, String param, String value) {
    String[] commands = new String[]{COMMAND_V4L2_CTL, PARAM_DEVICE, device, PARAM_LONG_SET_CTRL + param + "=" + value};
    executeSync(commands);
  }

  /**
   * Update custom param
   *
   * @param device
   * @param param
   * @param value
   */
  public static void update(String device, String param, int value) {
    update(device, param, Integer.toString(value));
  }

  /**
   * Update all settings based on current values
   *
   * @param settings
   */
  public static void update(String device, Settings settings) {
    List<String> commandList = buildUpdateCommand(device, settings);
    String[] commands = commandList.toArray(new String[commandList.size()]);

    executeSync(commands);
  }

  private static void executeSync(String[] commands) {
    ProcessBuilder b = new ProcessBuilder(commands);
    try {
      Process process = b.start();
      process.waitFor();
      process.destroy();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static List<String> buildUpdateCommand(Settings settings) {
    List<String> commandList = new ArrayList<>();

    commandList.add(COMMAND_V4L2_CTL);

    for (Param param : settings.parameters.values()) {
      commandList.add(PARAM_LONG_SET_CTRL + param.getName() + "=" + param.getValue());
    }
    return commandList;
  }

  private static List<String> buildUpdateCommand(String device, Settings settings) {
    List<String> commandList = buildUpdateCommand(settings);
    commandList.add(1, PARAM_DEVICE);
    commandList.add(1, device);
    return commandList;
  }

}

