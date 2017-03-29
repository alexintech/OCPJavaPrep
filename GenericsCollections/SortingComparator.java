import java.util.*;

public class SortingComparator {
  static class Rabbit { int id; }

  static class Duck implements Comparable<Duck> {
    String name;
    Duck(String name) {
      this.name = name;
    }
    public int compareTo(Duck d) {
      return name.compareTo(d.name);
    }
  }

  public static void main(String[] args) {
    List<Rabbit> rabbits = new ArrayList<>();
    rabbits.add(new Rabbit());
    //! Collections.sort(rabbits);  // CE: must be List<? extends Comparable<? super T>>

    Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
    Collections.sort(rabbits, c);   // OK, using special comparator

    List<String> names = Arrays.asList("Fluffy", "Hoppy");  // asc order
    Comparator<String> comp = Comparator.reverseOrder();    // desc order
    int index = Collections.binarySearch(names, "Hoppy", comp);
    System.out.println(index);    // -1 (Answer is undefined)

    comp = Comparator.naturalOrder();    // asc order
    index = Collections.binarySearch(names, "Hoppy", comp);
    System.out.println(index);    // 1 (OK)

    Set<Duck> ducks = new TreeSet<>();
    ducks.add(new Duck("Puddles"));
    Set<Rabbit> rabbs = new TreeSet<>();
    //! rabbs.add(new Rabbit());    // throws an exception:
                                    // cannot be cast to java.lang.Comparable

    Set<Rabbit> rabbit = new TreeSet<>(new Comparator<Rabbit>() {
      public int compare(Rabbit r1, Rabbit r2) {
        return r1.id - r2.id;
      }
    });
    rabbit.add(new Rabbit());   // OK
  }
}

