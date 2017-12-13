import java.util.function.*;

public class BiPredicateImpl {
  public static void main(String[] args) {
    BiPredicate<String, String> b1 = String::startsWith;
    BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);

    System.out.println(b1.test("chicken", "chick"));  // true
    System.out.println(b2.test("chicken", "chick"));  // true

    Predicate<String> egg = s -> s.contains("egg");
    Predicate<String> brown = s -> s.contains("brown");

    Predicate<String> brownEggs = egg.and(brown);
    Predicate<String> otherEggs = egg.and(brown.negate());

    System.out.println(brownEggs.test("brown egg"));    // true
    System.out.println(otherEggs.test("yellow egg"));   // true
  }
}

