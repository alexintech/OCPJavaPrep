import java.util.*;

public class ComparatorUsage {
  static class Duck implements Comparable<Duck> {
    private String name;
    private int weight;
    public Duck(String name, int weight) {
      this.name = name;
      this.weight = weight;
    }
    public String getName() { return name; }
    public int getWeight() { return weight; }
    public String toString() { return name + "(" + weight + ")"; }
    public int compareTo(Duck d) {
      return name.compareTo(d.name);
    }
  }

  public static class MultiFieldComparator implements Comparator<Duck> {
    public int compare(Duck d1, Duck d2) {
      int result = d1.getName().compareTo(d2.getName());
      if (result != 0) return result;
      return d1.getWeight() - d2.getWeight();
    }
  }

  public static class ChainingComparator implements Comparator<Duck> {
    public int compare(Duck d1, Duck d2) {
      Comparator<Duck> c = Comparator.comparing(d -> d.getName());
      c = c.thenComparingInt(d -> d.getWeight());
      return c.compare(d1, d2);
    }
  }

  public static void main(String[] args) {
    Comparator<Duck> byWeight = new Comparator<Duck>() {
      public int compare(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
      }
    };
    // OR
    Comparator<Duck> byWeight2 = (d1, d2) -> d1.getWeight() - d2.getWeight();
    List<Duck> ducks = new ArrayList<>();
    ducks.add(new Duck("Quack", 7));
    ducks.add(new Duck("Puddles", 10));
    Collections.sort(ducks);
    System.out.println(ducks);    // [Puddles(10), Quack(7)]
    Collections.sort(ducks, byWeight);
    System.out.println(ducks);    // [Quack(7), Puddles(10)]
    Collections.sort(ducks, byWeight2);
    System.out.println(ducks);    // [Quack(7), Puddles(10)]

    ducks.add(new Duck("Quack", 6));
    System.out.println(ducks);    // [Quack(7), Puddles(10), Quack(6)]
    Collections.sort(ducks, new MultiFieldComparator());
    System.out.println(ducks);    // [Puddles(10), Quack(6), Quack(7)]
    ducks.add(new Duck("Puddles", 5));
    Collections.sort(ducks, new ChainingComparator());
    System.out.println(ducks);    // [Puddles(5), Puddles(10), Quack(6), Quack(7)]
  }
}

