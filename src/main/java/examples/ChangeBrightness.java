package examples;

import com.harium.hci.v4l2.Settings;
import com.harium.hci.v4l2.V4L2Ctl;
import com.harium.hci.v4l2.params.Param;

public class ChangeBrightness {

  public static void main(String[] args) {
    Settings settings = V4L2Ctl.getSettings();
    settings.getBrightness().setValue("1");
    V4L2Ctl.update(settings);

    System.out.println(settings);
  }

}
