public class MultipleBounds {
  interface Wrappable {}
  interface Exchangeable {}
  class Gift {}
  class Phone extends Gift {}
  static class Parcel<T extends Gift & Exchangeable & Wrappable> {}
  //! static class Parcel2<T extends Exchangeable & Gift & Wrappable> {}  // CE:
      // class must be specified first
  //! static class Parcel3<T extends Gift & Phone & Wrappable> {}   // CE: must
      // be only one class

  class SuperGift extends Phone implements Wrappable, Exchangeable {}

  public static void main(String[] args) {
    Parcel<SuperGift> parcel = new Parcel<>();
    //! Parcel<Phone> parcelPhone = new Parcel<>();   // CE: Phone does not
          // implement Exchangeable and Wrappable interfaces
  }
}

