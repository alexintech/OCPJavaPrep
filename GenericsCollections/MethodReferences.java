import java.util.*;
import java.util.function.*;

public class MethodReferences {
  private static class Duck {
    private int weight;
    private String name;
  }

  static class DuckHelper {
    public static int compareByWeight(Duck d1, Duck d2) {
      return d1.weight - d2.weight;
    }
    public static int compareByName(Duck d1, Duck d2) {
      return d1.name.compareTo(d2.name);
    }
  }

  public static void main(String[] args) {
    Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
    Comparator<Duck> byWeight2 = DuckHelper::compareByWeight;

    // Reference to static method
    Consumer<List<Integer>> methodRef1 = Collections::sort;
    Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);
    List<Integer> sortedList = Arrays.asList(5, 3, 9, 2);
    methodRef1.accept(sortedList);
    System.out.println(sortedList);   // [2, 3, 5, 9]

    String str = "abc";
    // Reference to instance method on a particular instance
    Predicate<String> methodRef2 = str::startsWith;
    Predicate<String> lambda2 = s -> str.startsWith(s);
    System.out.println(methodRef2.test("ab"));  // true

    // Reference to instance method on an instance at runtime
    Predicate<String> methodRef3 = String::isEmpty;
    Predicate<String> lambda3 = s -> s.isEmpty();
    System.out.println(methodRef3.test("abc")); // false

    // Reference to constructor
    Supplier<ArrayList> methodRef4 = ArrayList::new;
    Supplier<ArrayList> lambda4 = () -> new ArrayList();
    System.out.println(methodRef4.get());       // []
  }
}

