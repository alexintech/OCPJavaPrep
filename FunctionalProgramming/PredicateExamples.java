import java.util.function.*;
import java.util.*;

public class PredicateExamples {
  public static void main(String[] args) {
    Predicate<String> nullCheck = arg -> arg != null;
    Predicate<String> emptyCheck = arg -> arg.length() > 0;
    Predicate<String> nullAndEmptyCheck = nullCheck.and(emptyCheck);
    String helloStr = "hello";
    System.out.println(nullAndEmptyCheck.test(helloStr));   // true

    String nullStr = null;
    System.out.println(nullAndEmptyCheck.test(nullStr));    // false

    List<String> greeting = new ArrayList<>();
    greeting.add("hello");
    greeting.add("world");

    // CE: lambda expression not expected here
    // greeting.removeIf((str -> str.startsWith("h")).negate());
    greeting.removeIf(((Predicate<String>) str -> str.startsWith("h")).negate());
    greeting.forEach(System.out::println);    // hello
  }
}

