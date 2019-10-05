package com.harium.hci.v4l2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class V4L2Ctl {

  public static final String COMMAND_V4L2_CTL = "v4l2-ctl";
  private Settings settings;

  public V4L2Ctl() {
    this(new Settings());
  }

  public V4L2Ctl(Settings settings) {
    this.settings = settings;
  }

  /**
   * List all v4l2-ctl settings
   */
  public static Settings getSettings() {
    ProcessBuilder builder = new ProcessBuilder(COMMAND_V4L2_CTL, "-l");
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

}

