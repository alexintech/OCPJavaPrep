import java.util.function.*;
import java.util.stream.*;

public class NoneMatch {
  public static void main(String[] args) {
    Predicate<? super String> predicate = s -> s.length() > 3;
    Stream<String> stream = Stream.iterate("-", (s) -> s + s);
    boolean b1 = stream.noneMatch(predicate);   // DOES NOT HANG ON
    System.out.println(b1);   // false
    //! boolean b2 = stream.anyMatch(predicate);    // throws exception: stream
                                                    // is already used
    Stream<String> s = Stream.generate(() -> "meow");
    boolean match = s.allMatch(String::isEmpty);    // false
    //! boolean match1 = s.noneMatch(String::isEmpty);    // hangs on
    //! boolean match2 = s.anyMatch(String::isEmpty);     // hangs on
    System.out.println(match);
  }
}

