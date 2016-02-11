package de.adrodoc55.mrc;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        MrcFrame frame = new MrcFrame();
        MrcFramePM pm = new MrcFramePM();
        frame.setPresentationModel(pm);
        frame.setVisible(true);
      }
    });
  }

}
