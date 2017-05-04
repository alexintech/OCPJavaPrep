import java.util.stream.*;
import java.util.regex.*;
import java.util.*;

public class StreamTerminalOps {
  public static void main(String[] args) {
    Object[] words = Pattern.compile(" ").splitAsStream("1 2 3 4 5")
      .toArray();
    System.out.println(Arrays.stream(words)
        .mapToInt(str -> Integer.valueOf((String) str)).sum()); // 15

    long sum = Pattern.compile(" ").splitAsStream("1 2 3 4 5")
      .mapToInt(Integer::valueOf)
      .sum();
    System.out.println(sum);  // 15

    IntStream chars = "bookkeep".chars();
    System.out.println(chars.count());    // 8    Stream is closed (consumed)
    //! Exception in thread "main" java.lang.IllegalStateException:
    // stream has already been operated upon or closed
    chars.distinct().sorted().forEach(ch -> System.out.printf("%c ", ch));
  }
}

