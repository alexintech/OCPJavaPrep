class Outer {
  private String greeting = "Hi";

  protected class Inner {
    public int repeat = 3;
    public void go() {
      for (int i = 0; i< repeat; i++)
        System.out.println(greeting);
    }
  }

  public void callInner() {
    Inner inner = new Inner();
    inner.go();
  }
}

public class InnerClass {
  public static void main(String[] args) {
    Outer outer = new Outer();
    outer.callInner();    // prints "Hi" three times

    //! Inner in = outer.new Inner();   // error: cannot find symbol
    Outer.Inner inner = outer.new Inner(); // you need to create Outer object
                                           // to create Inner object
    inner.go();   // prints "Hi" three times
  }
}
