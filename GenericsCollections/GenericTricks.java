import java.util.*;

public class GenericTricks {
  class A {}
  class B extends A {}
  class C extends B {}

  //! <T> <? extends T> method1(List<? extends T> list) { // CE: return type required
  //   return list.get(0);
  // }

  // B generic parameter shadows B class for this method
  <B extends A> B method3(List<B> list) {
    //! return new B(); // CE: B is a type-variable
    return null;
  }

  // OK. no generic parameters
  void mehtod4(List<? super B> list) {
  }

  // Try to mix method-specific type parameter with a wildcard
  //! <X> void method5(List<X super B> list) { }  // CE

  public static void main(String[] args) {
    //! List<?> list1 = new ArrayList<? extends A>();   // CE: unexpected type

  }
}

