package examples;

import com.harium.hci.v4l2.Settings;
import com.harium.hci.v4l2.V4L2Ctl;
import com.harium.hci.v4l2.params.Param;

public class ChangeAll {

  public static void main(String[] args) {
    Settings settings = V4L2Ctl.getSettings();
    System.out.println(settings);

    Param param = settings.getBrightness();
    param.setValue("1");

    param = settings.getParam("exposure_auto_priority");
    param.setValue("1");
    V4L2Ctl.update(settings);

  }

}
