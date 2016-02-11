package de.adrodoc55.mrc;

import java.text.NumberFormat;
import java.util.Locale;

public class RotationCalculator {

  public static void main(String[] args) {
    int r = 1;
    int rym = -3;
    int ry = 4;
    String template =
        "/execute @e[name=G_Main,${ry}]~ ~ ~ /tp @e[score_GL_M1_min=1,score_GL_M1=1,name=G_1,r=0,c=1] ${relative}";
    String result = insertCoords(template, r, rym, ry);
    System.out.println(result);
  }

  public static String insertCoords(String template, int r, int rym, int ry) {
    rym = rym < 180 ? rym : rym - 360;
    ry = ry < 180 ? ry : ry - 360;
    String rotation = calculateRotation(rym, ry);
    String relative = calculateRelative(r, rym, ry);
    String result = template.replace("${ry}", rotation).replace("${relative}", relative);
    return result;
  }

  private static String calculateRelative(int r, int rym, int ry) {
    double avgRy = (double) (ry + rym) / 2;
    double x = -r * Math.sin(Math.toRadians(avgRy));
    double z = r * Math.cos(Math.toRadians(avgRy));
    return "~" + dts(x) + " ~ ~" + dts(z);
  }

  private static String dts(double d) {
    NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
    nf.setMaximumFractionDigits(15);
    String result = nf.format(d);
    if ("0".equals(result))
      return "";
    else
      return result;
    // if (d == (long) d)
    // return String.format("%d", (long) d);
    // else
    // return String.format("%s", d);
  }

  private static String calculateRotation(int rym, int ry) {
    return "rym=" + rym + ",ry=" + ry;
  }
}
