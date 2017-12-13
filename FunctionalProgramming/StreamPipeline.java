import java.util.*;
import java.util.stream.*;

public class StreamPipeline {
  public static void main(String[] args) {
    List<String> cats = new ArrayList<>();
    cats.add("Annie");
    cats.add("Ripley");
    Stream<String> stream = cats.stream();
    cats.add("KC");
    System.out.println(stream.count());   // 3
  }
}

