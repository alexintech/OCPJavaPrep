import java.util.stream.*;
import java.util.function.*;
import java.util.*;

public class PrimitiveStreams {
  public static void main(String[] args) {
    DoubleStream empty = DoubleStream.empty();
    DoubleStream oneValue = DoubleStream.of(3.14);
    DoubleStream varargs = DoubleStream.of(1.0, 1.1, 3);
    oneValue.forEach(System.out::println);    // 3.14
    System.out.println();
    varargs.forEach(System.out::println);

    DoubleStream random = DoubleStream.generate(Math::random);
    DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
    random.limit(3).forEach(System.out::println);   // 3 random numbers
    System.out.println();
    fractions.limit(3).forEach(System.out::println);    // 0.5 0.25 0.125

    IntStream range = IntStream.range(1, 6);
    range.forEach(System.out::println);   // 1 2 3 4 5

    IntStream rangeClosed = IntStream.rangeClosed(1, 5);
    rangeClosed.forEach(System.out::println);   // 1 2 3 4 5

    IntStream stream = IntStream.rangeClosed(1, 10);
    OptionalDouble avg = stream.average();
    avg.ifPresent(System.out::println);       // 5.5
    System.out.println(avg.getAsDouble());    // 5.5
    System.out.println(avg.orElseGet(() -> Double.NaN));    // 5.5

    LongStream longs = LongStream.of(5, 10);
    long sum = longs.sum();
    System.out.println(sum);    // 15

    IntStream ints = IntStream.range(1, 10);
    IntSummaryStatistics stats = ints.summaryStatistics();
    if (stats.getCount() == 0) throw new RuntimeException();
    System.out.println(stats.getMax() - stats.getMin());    // 8
    System.out.println(stats.getCount());     // 9
    System.out.println(stats.getAverage());   // 5.0
    System.out.println(stats.getSum());       // 45

    BooleanSupplier b1 = () -> true;
    BooleanSupplier b2 = () -> Math.random() > .5;
    System.out.println(b1.getAsBoolean());    // true
    System.out.println(b2.getAsBoolean());    // random boolean
  }
}

