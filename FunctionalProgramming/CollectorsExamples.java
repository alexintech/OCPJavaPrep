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

    // ------- toMap() -------
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

    // --------- groupingBy() --------
    List<String> anim = Arrays.asList("lions", "tigers", "bears");
    Map<Integer, List<String>> grouped = anim.stream().collect(
        Collectors.groupingBy(String::length));
    System.out.println(grouped);   // {5=[lions, bears], 6=[tigers]}

    Map<Integer, Set<String>> grouped2 = anim.stream().collect(
        Collectors.groupingBy(String::length, Collectors.toSet()));
    System.out.println(grouped2);   // {5=[lions, bears], 6=[tigers]}

    TreeMap<Integer, Set<String>> grouped3 = anim.stream().collect(
        Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
    System.out.println(grouped2);   // {5=[lions, bears], 6=[tigers]}

    // --------- paritioningBy() -----
    Map<Boolean, List<String>> part1 = anim.stream().collect(
        Collectors.partitioningBy(s -> s.length() <= 5));
    System.out.println(part1);      // {false=[tigers], true=[lions, bears]}

    Map<Boolean, Set<String>> part2 = anim.stream().collect(
        Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
    System.out.println(part2);      // {false=[], true=[lions, tigers, bears]}

    // --------- mapping() ----------
    Map<Integer, Optional<Character>> res = anim.stream().collect(
        Collectors.groupingBy(
          String::length,
          Collectors.mapping(s -> s.charAt(0),
            Collectors.minBy(Comparator.<Character>naturalOrder()))));
    System.out.println(res);   // {5=Optional[b], 6=Optional[t]}
  }
}

