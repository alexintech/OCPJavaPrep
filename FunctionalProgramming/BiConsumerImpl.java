import java.util.*;
import java.util.function.*;

public class BiConsumerImpl {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    BiConsumer<String, Integer> b1 = map::put;
    BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

    b1.accept("chicken", 7);
    b2.accept("chick", 1);

    System.out.println(map);  // {chicken=7, chick=1}
  }
}

