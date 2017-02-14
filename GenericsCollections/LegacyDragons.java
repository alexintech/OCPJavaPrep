import java.util.*;

public class LegacyDragons {
  static class Dragon {}
  static class Unicorn {}

  public static void main(String[] args) {
    List unicorns = new ArrayList();
    unicorns.add(new Unicorn());
    printDragons(unicorns);
  }
  private static void printDragons(List<Dragon> dragons) {
    for (Dragon dragon : dragons) {   // ClassCastException
      System.out.println(dragon);
    }
  }
}

