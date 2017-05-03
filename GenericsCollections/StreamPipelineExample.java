import java.util.*;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class StreamPipelineExample {
  public static void main(String[] args) {
    Arrays.stream(Object.class.getMethods())    // source
      .map(method -> method.getName())          // intermediate op
      .distinct()                               // intermediate op
      .forEach(System.out::println);            // terminal operation

    System.out.println();

    Method[] objectMethods = Object.class.getMethods();
    Stream<Method> objectMethodStream = Arrays.stream(objectMethods);
    Stream<String> objectMethodNames = objectMethodStream.map(
            method -> method.getName()
        );
    Stream<String> uniqueObjectMethodNames = objectMethodNames.distinct();
    uniqueObjectMethodNames.forEach(System.out::println);
  }
}

