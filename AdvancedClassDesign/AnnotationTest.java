// error: AnnotationTest is not a functional interface
/*!
@FunctionalInterface
public abstract class AnnotationTest {
  abstract int foo();
}
*/

@FunctionalInterface
public interface AnnotationTest {
  int foo();
}

// error: no abstract method found in interface AnnotationTest1
/*!
@FunctionalInterface
public interface AnnotationTest1 {
  default int foo() { }
}
*/

// error: no abstract method found in interface AnnotationTest2
/*!
@FunctionalInterface
public interface AnnotationTest2 {
}
*/

// error: multiple non-overriding abstract methods found in interface AnnotationTest3
/*!
@FunctionalInterface
public interface AnnotationTest3 {
  int foo();
  int bar();
}
*/

@FunctionalInterface
interface AnnotationTest4 {
  int foo();
  boolean equals(Object obj);  // OK. It's still a functional interface
}

// error: no abstract method found in interface AnnotationTest5
/*!
@FunctionalInterface
interface AnnotationTest5 {
  boolean equals(Object obj);  // no abstract method
}
*/
