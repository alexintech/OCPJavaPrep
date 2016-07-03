public class LocalInnerClass {
  private int length = 5;
  public void calculate() {
    int width = 20;
    class Inner {
      public void multiply() {
        System.out.println(length * width);
      }
    }
    //! width = 10;   // error: local variables referenced from an inner class
                      // must be final or effectively final
    Inner inner = new Inner();
    inner.multiply();
  }

  public static void main(String[] args) {
    LocalInnerClass outer = new LocalInnerClass();
    outer.calculate();    // prints 100
  }
}
