public class AnonInner {
  abstract class SaleTodayOnly {
    abstract int dollarsOff();
    static final int a = 5;   // static final constants are allowed
                              // in inner classes
  }

  public interface SaleToday {
    public static int sale() { return 5; } // static methods are allowed in
        // inner interfaces
  }

  public int admission(int basePrice) {
    SaleTodayOnly sale = new SaleTodayOnly() {
      int dollarsOff() { return basePrice/4 - 3; } // you can use final or
                // effectively final local variables in inner class
    };
    return basePrice - sale.dollarsOff();
  }

  public static void main(String[] args) {
    AnonInner anon = new AnonInner();
    System.out.println(anon.admission(100));  // prints 78
  }
}

