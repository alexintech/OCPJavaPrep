import java.util.*;

public class UpperBoundedWildcards {
  public static long total(List<? extends Number> list) {
    long count = 0;
    for (Number number : list)
      count += number.longValue();
    return count;
  }

  public static void main(String[] args) {
    ArrayList<Integer> ints = new ArrayList<>();
    ints.add(5);
    ints.add(3);
    System.out.println(total(ints));    // prints 8

    List<? extends Number> list = ints;
    // list.add(5);   // CE: logically immutable
    list.remove(1);   // you can remove elements
    System.out.println(total(ints));    // prints 5

  }
}

