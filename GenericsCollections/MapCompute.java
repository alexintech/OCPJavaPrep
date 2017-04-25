import java.util.*;
import java.util.function.*;

public class MapCompute {
  public static void main(String[] args) {
    Map<String, Integer> counts = new HashMap<>();
    counts.put("Jenny", 1);
    counts.put("Tom", null);

    BiFunction<String, Integer, Integer> mapper = (k, v) -> v + 1;
    Integer jenny = counts.computeIfPresent("Jenny", mapper);
    Integer sam = counts.computeIfPresent("Sam", mapper);
    System.out.println(counts);   // {Jenny=2}
    System.out.println(jenny);    // 2
    System.out.println(sam);      // null

    Function<String, Integer> mapper2 = (k) -> 1;
    Integer jenny2 = counts.computeIfAbsent("Jenny", mapper2);  // 2
    Integer sam2 = counts.computeIfAbsent("Sam", mapper2);      // 1
    Integer tom = counts.computeIfAbsent("Tom", mapper2);       // 1
    System.out.println(counts);   // {Tom=1, Jenny=2, Sam=1}

    counts.computeIfPresent("Jenny", (k, v) -> null);   // removes mapping
    counts.computeIfAbsent("Joe", k -> null);   // do nothing
    System.out.println(counts);   // {Tom=1, Sam=1}
  }
}

