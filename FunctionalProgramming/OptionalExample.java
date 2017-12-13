import java.util.*;

public class OptionalExample {
  public static Optional<Double> average(int... scores) {
    if (scores.length == 0) return Optional.empty();

    int sum = 0;
    for (int score : scores) sum += score;

    return Optional.of((double) sum / scores.length);
  }

  public static void main(String[] args) {
    System.out.println(average(90, 100));   // Optional[95.0]
    System.out.println(average());          // Optional.empty

    Optional<Double> opt = average(90, 100);
    if (opt.isPresent())
      System.out.println(opt.get());  // 95.0

    Optional<Double> opt2 = average();
    // throws java.util.NoSuchElementException: No value present
    // System.out.println(opt2.get());

    String value = null;
    Optional o = Optional.ofNullable(value);
    System.out.println(o);    // Optional.empty

    opt.ifPresent(System.out::println);   // 95.0
    opt2.ifPresent(System.out::println);  // do nothing

    System.out.println(opt2.orElse(Double.NaN));
    System.out.println(opt2.orElseGet(() -> Math.random()));
    System.out.println(opt2.orElseThrow(() -> new IllegalStateException()));
  }
}

