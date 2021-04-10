public class FinalFor {
  enum Flavors {
    VANILA, CHOCOLATE, STRAWBERRY;
    static final Flavors DEFAULT = STRAWBERRY;
  }

  public static void main(String[] args) {
    for(final var e : Flavors.values())       // OK
      System.out.print(e.ordinal() + " ");    // 0 1 2
  }
}

