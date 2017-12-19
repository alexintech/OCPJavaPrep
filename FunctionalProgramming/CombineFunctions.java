import java.util.*;
import java.util.function.*;

public class CombineFunctions {
  public static void main(String[] args) {
    Function<String, Integer> parseInt = Integer::parseInt;
    Function<Integer, Integer> absInt = Math::abs;
    Function<String, Integer> parseAndAbsInt = parseInt.andThen(absInt);
    // or
    Function<String, Integer> parseAndAbsInt1 = absInt.compose(parseInt);

    Arrays.stream("4, -9, 16".split(", "))
      .map(parseAndAbsInt)
      .forEach(System.out::println);    // 4 9 16

    Arrays.stream("4, -9, 16".split(", "))
      .map(parseAndAbsInt1)
      .forEach(System.out::println);    // 4 9 16

    // run constructor with arg: new String("100")
    Function<String, String> anotherString = String::new;
    System.out.println(anotherString.apply("100"));  // 100

    ObjIntConsumer<String> charAt = (str, i) -> str.charAt(i);    // OK
    // CE: void type is not allowed here
    //! System.out.println(charAt.accept("java", 2));
  }
}

