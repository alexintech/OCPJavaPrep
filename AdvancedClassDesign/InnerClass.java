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

  private int x = 10;
  class B {
    private int x = 20;
    class C {
      private int x = 30;
      public void allTheX() {
        System.out.println(x);               // 30
        System.out.println(this.x);          // 30
        System.out.println(B.this.x);        // 20
        System.out.println(Outer.this.x);    // 10
      }
    }
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

    Outer a = new Outer();
    Outer.B b = a.new B();
    Outer.B.C c = b.new C();
    c.allTheX();
  }
}
