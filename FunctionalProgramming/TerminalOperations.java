import java.util.stream.*;
import java.util.function.*;
import java.util.*;

public class TerminalOperations {
  public static void main(String[] args) {
    Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
    System.out.println(s.count());  // 3

    s = Stream.of("monkey", "ape", "bonobo");
    Optional<String> min = s.min((s1, s2) -> s1.length()-s2.length());
    min.ifPresent(System.out::println);   // ape

    Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
    System.out.println(minEmpty.isPresent());   // false

    s = Stream.of("monkey", "gorilla", "bonobo");
    Stream<String> infinite = Stream.generate(() -> "chimp");
    s.findAny().ifPresent(System.out::println);           // monkey
    infinite.findAny().ifPresent(System.out::println);    // chimp

    List<String> list = Arrays.asList("monkey", "2", "chimp");
    infinite = Stream.generate(() -> "chimp");
    Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
    System.out.println(list.stream().anyMatch(pred));   // true
    System.out.println(list.stream().allMatch(pred));   // false
    System.out.println(list.stream().noneMatch(pred));   // false
    System.out.println(infinite.anyMatch(pred));        // true

    list.stream().forEach(System.out::print); // monkey2chimp
    System.out.println();

    String word = Stream.of("w", "o", "l", "f")
                        .reduce("", (a, c) -> a + c);
    System.out.println(word);   // wolf

    BinaryOperator<Integer> op = (a, b) -> a * b;
    Stream<Integer> empty = Stream.empty();
    Stream<Integer> oneElement = Stream.of(3);
    Stream<Integer> threeElements = Stream.of(3, 5, 6);

    empty.reduce(op).ifPresent(System.out::println);         // no output
    oneElement.reduce(op).ifPresent(System.out::println);    // 3
    threeElements.reduce(op).ifPresent(System.out::println); // 90

    Stream<String> stream = Stream.of("w", "o", "l", "f");
    StringBuilder wolf = stream.collect(StringBuilder::new,
        StringBuilder::append, StringBuilder::append);
    System.out.println(wolf.toString());      // wolf

    stream = Stream.of("w", "o", "l", "f");
    TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add,
        TreeSet::addAll);
    System.out.println(set);    // [f, l, o, w]

    TreeSet<String> set2 = Stream.of("w", "o", "l", "f")
        .collect(Collectors.toCollection(TreeSet::new));
    System.out.println(set2);    // [f, l, o, w]

    Set<String> set3 = Stream.of("w", "o", "l", "f")
        .collect(Collectors.toSet());
    System.out.println(set3);    // [f, w, l, o]
  }
}

