package com.harium.hci.v4l2;

import com.harium.hci.v4l2.params.BoolParam;
import com.harium.hci.v4l2.params.IntParam;
import com.harium.hci.v4l2.params.MenuParam;
import com.harium.hci.v4l2.params.Param;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Parser {

  static void parseLine(Settings settings, String line) {
    String[] parts = line.split(":");
    String common = parts[0].trim();
    Param param = Parser.parseParamType(common);

    String valuesPart = parts[1].trim();
    Map<String, String> values = Parser.parseValues(valuesPart);
    parseParam(param, values);

    settings.parameters.put(param.getName(), param);
  }

  static Param parseParamType(String common) {
    String[] paramParts = common.split(" ");
    String type = paramParts[2].substring(1, paramParts[2].length() - 1);

    Param param;
    if (Param.BOOL.equals(type)) {
      param = new BoolParam();
    } else if (Param.INT.equals(type)) {
      param = new IntParam();
    } else if (Param.MENU.equals(type)) {
      param = new MenuParam();
    } else {
      param = new Param();
    }
    param.setType(type);

    param.setName(paramParts[0]);
    param.setAddress(paramParts[1]);
    return param;
  }

  static Map<String, String> parseValues(String valuesPart) {
    Map<String, String> values = new HashMap<String, String>();
    String[] valuesText = valuesPart.split(" ");

    for (String v : valuesText) {
      String[] value = v.split("=");
      values.put(value[0], value[1]);
    }

    return values;
  }

  static void parseParam(Param param, Map<String, String> values) {
    for (Entry<String, String> entry : values.entrySet()) {
      String key = entry.getKey();
      if ("min".equals(key)) {
        param.setMin(entry.getValue());
      } else if ("max".equals(key)) {
        param.setMax(entry.getValue());
      } else if ("step".equals(key)) {
        param.setStep(entry.getValue());
      } else if ("default".equals(key)) {
        param.setDefaultValue(entry.getValue());
      } else if ("value".equals(key)) {
        param.setValue(entry.getValue());
      }
    }
    //param.setValue();
  }

}
