public class GenericMethods {
  static class Crate<T> {
  }

  public static <T> Crate<T> ship(T t) {
    System.out.println("Preparing " + t);
    return new Crate<T>();
  }

  public static <T> void sink(T t) { }
  public static <T> T identity(T t) {
    return t;
  }
  //! public static T noGood(T t) {   // error: cannot find symbol
  //   return t;
  // }
  public static void main(String[] args) {
    GenericMethods.ship("package");
    GenericMethods.<String>ship("package");
    GenericMethods.<String[]>ship(args);
    //! <String>ship("package");  // CE: illegal start of expression
    //! GenericMethods.<String[]>ship("package"); // CE: incompatible types
  }
}

