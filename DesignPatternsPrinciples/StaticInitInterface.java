public interface StaticInitInterface {
  public static final int value = 5;

  /*! An interface can't define a static initializer block to init its vars
  static {
    value = 5;
  }
  */
}

