package com.harium.hci.v4l2;

import com.harium.hci.v4l2.params.Param;
import java.util.LinkedHashMap;
import java.util.Map;

public class Settings {

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
}
