class Base {
  static {
    System.out.print("STATIC:");      // 1
  }
  {
    System.out.print("INIT:");        // 3
  }
}
class InitializationOrder extends Base {
  static {
    System.out.print("static-der:");  // 2
  }
  {
    System.out.print("init-der:");    // 4
  }
  public static void main(String[] args) {
    new InitializationOrder(); // STATIC:static-der:INIT:init-der:
  }
}

