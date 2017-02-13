import java.util.*;

public class GenericTypeLimitations<T> {

  //! private static T staticVar;   // error: non-static type variable T
                    // cannot be referenced from a static context

  private void doSomething() {
    //! Object obj = new T();   // error: you can't call the constructor
    //! T[] objects = new T[5];     // error: generic array creation
    //! Object[] objects = new T[5];     // error: generic array creation
    //! T[] objects = new Object[5];     // error: incompatible types:
                // Object[] cannot be converted to T[]

    Object obj = new String();
    //! if (obj instanceof T) {   // error: illegal generic type for instanceof
    //  System.out.println("obj instanceof T");
    // }
  }

  public static void main(String[] args) {
    // You can't use a primitive type as a generic type parameter
    //! GenericTypeLimitations<int> genericType = new GenericTypeLimitations<>();
    GenericTypeLimitations<Integer> genericType = new GenericTypeLimitations<>();

    List<Integer> integers = new ArrayList<>();
    //! if (integers instanceof List<String>) ;   //  error: illegal generic
                                                  // type for instanceof

  }
}

