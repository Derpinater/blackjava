/**
 * @author Marcus Walker
 */

// imports
import java.lang.Runtime;

public class Exec {
  public static void main(String[] strings) {
    try {
      Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
    } catch(Exception e) {
      System.out.println("HEY BUDDY! ur doing something worng, can ya` not!?");
      e.printStackTrace();
    }
  }
}