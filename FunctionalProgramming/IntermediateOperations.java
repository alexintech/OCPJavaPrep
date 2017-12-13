import java.util.stream.*;
import java.util.*;

public class IntermediateOperations {
  public static void main(String[] args) {
    Stream<String> s1 = Stream.of("monkey", "gorilla", "bonobo");
    s1.filter(x -> x.startsWith("m"))
      .forEach(System.out::print);      // monkey
    System.out.println();

    Stream<String> s2 = Stream.of("duck", "duck", "goose", "duck");
    s2.distinct()
      .forEach(System.out::print);      // duckgoose
    System.out.println();

    Stream<Integer> s3 = Stream.iterate(1, n -> n + 1);
    s3.skip(5).limit(2)
      .forEach(System.out::print);      // 67
    System.out.println();

    Stream<String> s4 = Stream.of("monkey", "gorilla", "bonobo");
    s4.map(String::length)
      .forEach(System.out::print);      // 676
    System.out.println();

    List<String> zero = Arrays.asList();
    List<String> one = Arrays.asList("Bonobo");
    List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
    Stream<List<String>> animals = Stream.of(zero, one, two);

    animals.flatMap(l -> l.stream())
      .forEach(System.out::println);      // Bonobo
                                          // Mama Gorilla
                                          // Baby Gorilla

    Stream<String> s5 = Stream.of("brown-", "bear-");
    s5.sorted()
      .forEach(System.out::print);      // bear-brown-
    System.out.println();

    Stream<String> s6 = Stream.of("brown bear-", "grizzly-");
    s6.sorted(Comparator.reverseOrder())
      .forEach(System.out::print);      // grizzly-brown bear-
    System.out.println();

    // peek() examples
    List<Integer> numbers = new ArrayList<>();
    List<Character> letters = new ArrayList<>();
    numbers.add(1);
    letters.add('a');
    Stream<List<?>> stream = Stream.of(numbers, letters);
    stream.map(List::size).forEach(System.out::print);    // 11
    System.out.println();

    StringBuilder builder = new StringBuilder();
    Stream<List<?>> good = Stream.of(numbers, letters);
    good.peek(l -> builder.append(l))
      .map(List::size).forEach(System.out::print);    // 11
    System.out.println();
    System.out.println(builder);    // [1][a]

    Stream<List<?>> bad = Stream.of(numbers, letters);
    bad.peek(l -> l.remove(0))
      .map(List::size).forEach(System.out::print);    // 00
    System.out.println();

    Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
    infinite.filter(x -> x % 2 == 1)
      .peek(System.out::print)
      .limit(5)     // pass value through
      .forEach(System.out::print);    // 1133557799
  }
}

