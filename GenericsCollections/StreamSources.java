import java.util.*;
import java.util.stream.*;
import java.util.regex.*;
import java.nio.file.*;
import java.io.*;

public class StreamSources {
  private static <T> void print(Stream<T> stream) {
    stream.forEach(System.out::println);
    System.out.println();
  }

  private static void print(IntStream stream) {
    stream.forEach(System.out::println);
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    print(IntStream.range(1, 6)); // 1 2 3 4 5
    print(IntStream.iterate(1, i -> i + 2).limit(5));   // 1 3 5 7 9
    print(Arrays.stream(new int[] {4, 5, 6, 7}));       // 4 5 6 7
    print(Arrays.stream(new Integer[] {4, 5, 6, 7}));   // 4 5 6 7
    print(Stream.of(5, 4, 3));                          // 5 4 3
    print(Stream.of(new Integer[]{1, 2, 3}));           // 1 2 3
    print(Stream.builder().add(1).add(2).add(5).build());   // 1 2 5

    List<String> strings = Arrays.asList("eeny", "meeny", "miny");
    print(strings.stream());    // eeny meeny miny

    print(Files.lines(Paths.get("./hello.txt")));   // prints the file

    print(Pattern.compile(" ").splitAsStream("java 8 streams"));
          // java 8 streams

    print(new Random().ints().limit(5));  // prints 5 random numbers

    "hello".chars().sorted()
      .forEach(ch -> System.out.printf("%c ", ch));   // e h l l o
  }
}

