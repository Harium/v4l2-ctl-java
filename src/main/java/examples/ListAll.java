package examples;

import com.harium.hci.v4l2.Settings;
import com.harium.hci.v4l2.V4L2Ctl;

public class ListAll {

  public static void main(String[] args) {
    Settings settings = V4L2Ctl.getSettings();
    System.out.println(settings);
  }

}
