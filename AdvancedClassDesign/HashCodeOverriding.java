import java.util.*;

public class HashCodeOverriding {

  static class MyNumber {
    int primary, secondary;
    MyNumber(int primary, int secondary) {
      this.primary = primary;
      this.secondary = secondary;
    }
    public int hashCode() {
      return secondary;  // doesn't print same hashCode() value for equal objects
    }
    public boolean equals(Object o) {
      if (o != null && o instanceof MyNumber)
        return (primary == ((MyNumber)o).primary);
      else
        return false;
    }
  }

  static class MyNumberUnconsistent {
    int number;
    MyNumberUnconsistent(int number) { this.number = number; }
    public int hashCode() {
      return ((int)(Math.random() * 100));
    }
    public boolean equals(Object o) {
      if (o != null && o instanceof MyNumberUnconsistent)
        return (number == ((MyNumberUnconsistent)o).number);
      else
        return false;
    }
  }

  static class MyNumberMutable {
    int number;
    MyNumberMutable(int number) { this.number = number; }
    public int hashCode() {
      return number;
    }
    public boolean equals(Object o) {
      if (o != null && o instanceof MyNumberMutable)
        return (number == ((MyNumberMutable)o).number);
      else
        return false;
    }
  }

  public static void main(String[] args) {
    Map<MyNumber, String> map = new HashMap<>();
    MyNumber num1 = new MyNumber(2500, 100);
    MyNumber num2 = new MyNumber(2500, 200);
    System.out.println(num1.equals(num2));    // true
    map.put(num1, "Shreya");
    System.out.println(map.get(num2));    // null

    Map<MyNumberUnconsistent, String> map1 = new HashMap<>();
    MyNumberUnconsistent num3 = new MyNumberUnconsistent(2500);
    map1.put(num3, "Alex");
    System.out.println(map1.get(num3));   // null

    // Using mutable objects as keys
    Map<MyNumberMutable, String> map2 = new HashMap<>();
    MyNumberMutable num4 = new MyNumberMutable(2500);
    map2.put(num4, "Alexandr");
    num4.number = 100;
    System.out.println(map2.get(num4));   // null - can't locate object with
                                          // modified key
  }
}

