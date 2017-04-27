public class TypeInference {
  static class Parcel<T> {
    <U> Parcel(U u) { }
    public <X> void deliver(X x) {
      System.out.println(x.getClass());
    }
    public <K> K doIt(String str) {
      return (K)str;
    }
  }
  public static void main(String[] args) {
    Parcel<String> parcel = new Parcel<>(new StringBuilder("Java"));
    parcel.<Integer>deliver(new Integer(10));
    //! parcel.<>deliver(new Integer(10));  // CE: can't use <> with generic method
    parcel.deliver("Hello");
    parcel.doIt("Bad");
  }
}

