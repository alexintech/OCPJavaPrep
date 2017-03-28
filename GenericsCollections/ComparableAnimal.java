public class ComparableAnimal implements Comparable<ComparableAnimal> {
  private int id;
  public int compareTo(ComparableAnimal a) {
    return id - a.id;
  }
  public static void main(String[] args) {
    ComparableAnimal a1 = new ComparableAnimal();
    ComparableAnimal a2 = new ComparableAnimal();
    a1.id = 5;
    a2.id = 7;
    System.out.println(a1.compareTo(a2));   // -2
    System.out.println(a1.compareTo(a1));   // 0
    System.out.println(a2.compareTo(a1));   // 2
  }
}

