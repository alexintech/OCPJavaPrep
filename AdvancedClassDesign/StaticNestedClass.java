public class StaticNestedClass {
  static class Nested {
    private int price = 6;  // you are allowed to access private variables
  }
  public static void main(String[] args) {
    Nested nested = new Nested();
    System.out.println(nested.price); // prints 6
  }
}

