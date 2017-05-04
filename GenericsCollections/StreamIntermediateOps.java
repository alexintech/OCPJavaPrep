import java.util.stream.*;

public class StreamIntermediateOps {
  public static void main(String[] args) {
    Stream.of(1, 2, 3, 4, 5)
      .peek(i -> System.out.printf("%d ", i))
      .map(i -> i * i)
      .peek(i -> System.out.printf("%d ", i))
      .count();   // 5
    // prints 1 1 2 4 3 9 4 16 5 25
    System.out.println();

    IntStream.rangeClosed(0, 10)
      .filter(i -> (i % 2) == 0)
      .map(i -> i * i)
      .forEach(System.out::println);    // 0 4 16 36 64 100
  }
}

