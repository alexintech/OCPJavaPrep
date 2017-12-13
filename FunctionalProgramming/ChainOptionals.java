import java.util.*;

public class ChainOptionals {

  private static void threeDigit(Optional<Integer> optional) {
    optional.map(n -> "" + n)
      .filter(s -> s.length() == 3)
      .ifPresent(System.out::println);
  }

  static Optional<Integer> calculator(String s) {
    if (s == null) return Optional.empty();
    return Optional.of(s.length());
  }

  public static void main(String[] args) {
    threeDigit(Optional.empty());     // no output
    threeDigit(Optional.of(4));       // no output
    threeDigit(Optional.of(123));     // 123

    Optional<String> source = Optional.of("abcd");
    // CE: incompatible types
    //! Optional<Integer> result = source.map(ChainOptionals::calculator);
    Optional<Integer> result = source.flatMap(ChainOptionals::calculator);
    result.ifPresent(System.out::println);    // 4
  }
}

