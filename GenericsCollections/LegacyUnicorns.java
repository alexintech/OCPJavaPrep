import java.util.*;

public class LegacyUnicorns {
  static class Unicorn { }
  static class Dragon { }

  public static void main(String[] args) {
    List<Unicorn> unicorns = new ArrayList<>();
    addUnicorn(unicorns);
    Unicorn unicorn = unicorns.get(0);  // ClassCastException
  }
  private static void addUnicorn(List unicorn) {
    unicorn.add(new Dragon());
  }
}

