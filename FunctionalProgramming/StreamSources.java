import java.util.stream.*;
import java.util.*;

public class StreamSources {
  public static void main(String[] args) {
    Stream<String> empty = Stream.empty();          // count = 0
    Stream<Integer> singleElement = Stream.of(1);   // count = 1
    Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3

    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> fromList = list.stream();
    Stream<String> fromListParallel = list.parallelStream();

    // infinite streams
    Stream<Double> randoms = Stream.generate(Math::random);
    Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
  }
}

