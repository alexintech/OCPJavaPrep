import java.util.*;

public class HashSetUsage {
  static class Person {
    String name;
    Person(String name) { this.name = name; }
    public String toString() { return name; }
    public boolean equals(Object o) {
      if (o instanceof Person) {
        return this.name.equals(((Person) o).name);
      }
      return false;
    }
  }

  public static void main(String[] args) {
    HashSet<Person> set = new HashSet<Person>();
    Person p1 = new Person("Harry");
    Person p2 = new Person("Shreya");
    Person p3 = new Person("Selvan");
    Person p4 = new Person("Shreya");
    set.add(p1);
    set.add(p2);
    set.add(p3);
    set.add(p4);    // first calls hashCode() to choose a bucket,
                    // then calls equals() to elements in a bucket
                    // Person doesn't override hashCode() -> it will be put
                    // to different bucket

    System.out.println(set);    // [Harry, Shreya, Selvan, Shreya]
  }
}

