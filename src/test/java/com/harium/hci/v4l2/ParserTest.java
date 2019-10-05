package com.harium.hci.v4l2;

import static org.junit.Assert.assertEquals;

import com.harium.hci.v4l2.params.Param;
import java.util.Map;
import org.junit.Test;

public class ParserTest {

  @Test
  public void testParseCommonPart() {
    String commonPart = "brightness 0x00980900 (int)  ";
    Param param = Parser.parseParamType(commonPart);

    assertEquals("brightness", param.getName());
    assertEquals("0x00980900", param.getAddress());
    assertEquals("int", param.getType());
  }

  @Test
  public void testParseValuesPart() {
    String valuesPart = "min=-64 max=222 step=1 default=0 value=39";
    Map<String, String> values = Parser.parseValues(valuesPart);

    assertEquals("-64", values.get("min"));
    assertEquals("222", values.get("max"));
    assertEquals("1", values.get("step"));
    assertEquals("0", values.get("default"));
    assertEquals("39", values.get("value"));
  }

}
