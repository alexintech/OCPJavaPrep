import java.util.*;

public class DiamondOperator {
  List<String> names;
  DiamondOperator() {
    names = new ArrayList<>();    // matches instance variable
  }
  public void copyNames() {
    ArrayList<String> copyOfNames;
    copyOfNames = new ArrayList<>();  // matches local variable
  }
}

