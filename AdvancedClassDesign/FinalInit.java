public class FinalInit {
  static abstract class MyClass {
    //! public final int finalVar; // must be initialized in the class in which it's
                               // declared
  }
  static class MyDerivedClass extends MyClass {
    MyDerivedClass() {
      super();
      //! finalVar = 1000; // error: cannot assign a value to final variable
    }
  }
  public static void main(String[] args) {
    // System.out.println(new MyDerivedClass().finalVar);
  }
}

