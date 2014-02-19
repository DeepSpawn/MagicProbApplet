package gt.magicprobabilityapplet;
import javax.swing.*;

public class HypGeoGui {
  
  
  public static void main(String [ ] args) { 
    
    JFrame frame = new JFrame("Land drop"); // 1 make frame / window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 2 define close behaviour
    frame.getContentPane().add( new HypGeoPanel() ); // 3 add support panel 
    frame.pack(); // 4 auto size the frame
    frame.setVisible(true); // 5 make frame visible
  }
  
}