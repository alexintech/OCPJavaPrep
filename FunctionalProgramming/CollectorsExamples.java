import java.util.stream.*;
import java.util.*;

public class CollectorsExamples {
  public static void main(String[] args) {
    Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
    String result = ohMy.collect(Collectors.joining(", "));
    System.out.println(result);     // lions, tigers, bears

    Stream<String> animals = Stream.of("lions", "tigers", "bears");
    Double result2 = animals.collect(Collectors.averagingInt(String::length));
    System.out.println(result2);     // 5.33333333333333

    Stream<String> animals2 = Stream.of("lions", "tigers", "bears");
    Map<String, Integer> map1 = animals2.collect(
        Collectors.toMap(s -> s, String::length));
    System.out.println(map1);   // {lions=5, bears=5, tigers=6}

    Stream<String> animals3 = Stream.of("lions", "tigers", "bears");
    // throws IllegalStateException: duplicate key 5
    // Map<Integer, String> map2 = animals3.collect(
    //     Collectors.toMap(String::length, k -> k));
    Map<Integer, String> map2 = animals3.collect(
        Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
    System.out.println(map2);   // {5=lions,bears, 6=tigers}
    System.out.println(map2.getClass());    // class java.util.HashMap

    Stream<String> animals4 = Stream.of("lions", "tigers", "bears");
    Map<Integer, String> map3 = animals4.collect(
        Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2,
          TreeMap::new));
    System.out.println(map3);   // {5=lions,bears, 6=tigers}
    System.out.println(map3.getClass());    // class java.util.TreeMap
  }
}

