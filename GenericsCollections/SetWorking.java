import java.util.*;

public class SetWorking {
  public static void usingHashSet() {
    Set<Integer> set = new HashSet<>();
    boolean b1 = set.add(66);   // true
    boolean b2 = set.add(10);   // true
    boolean b3 = set.add(66);   // false
    boolean b4 = set.add(8);    // true
    for (Integer integer : set)
      System.out.print(integer + ",");  // 66,8,10,
    System.out.println();

    Iterator<Integer> iter = set.iterator();
    while (iter.hasNext()) {
      Integer integer = iter.next();
      System.out.print(integer + "|");
    }
    System.out.println();
  }

  public static void usingTreeSet() {
    Set<Integer> set = new TreeSet<>();
    boolean b1 = set.add(66);   // true
    boolean b2 = set.add(10);   // true
    boolean b3 = set.add(66);   // false
    boolean b4 = set.add(8);    // true
    for (Integer integer : set)
      System.out.print(integer + ",");  // 8,10,66,
    System.out.println();

    // before Java 5
    Iterator iter = set.iterator();
    while (iter.hasNext()) {
      Integer integer = (Integer) iter.next();
      System.out.print(integer + "|");
    }
    System.out.println();
  }

  public static void usingNavigableSet() {
    NavigableSet<Integer> set = new TreeSet<>();
    for (int i = 1; i <= 20; i++) set.add(i);
    System.out.println(set.lower(10));    // 9
    System.out.println(set.floor(10));    // 10
    System.out.println(set.ceiling(20));  // 20
    System.out.println(set.higher(20));   // null
  }

  public static void main(String[] args) {
    usingHashSet();
    usingTreeSet();
    usingNavigableSet();
  }
}

