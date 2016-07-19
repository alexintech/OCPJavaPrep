enum Level {
  BEGINNER;
  static {
    System.out.println("static init block");  // 2
  }
  Level() {
    System.out.println("constructor");        // 1
  }
  public static void main(String[] args) {
    System.out.println(Level.BEGINNER);       // 3
    // constructor
    // static init block
    // BEGINNER
  }
}

//! class LevelEx extends Enum { }  // error: classes cannot directly
                                    // extend java.lang.Enum
