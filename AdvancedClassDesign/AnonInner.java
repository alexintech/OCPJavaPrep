public class AnonInner {
  abstract class SaleTodayOnly {
    abstract int dollarsOff();
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
