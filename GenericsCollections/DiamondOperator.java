import java.util.*;

public class DiamondOperator {
  List<String> names;
  Float variable = new Float(1.0);  // constructor Float(double) exists
  DiamondOperator() {
    names = new ArrayList<>();    // matches instance variable
  }
  public void copyNames() {
    ArrayList<String> copyOfNames;
    copyOfNames = new ArrayList<>();  // matches local variable
  }
}

