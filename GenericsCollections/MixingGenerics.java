public class MixingGenerics {
  static class Parcel<T> {
    private T t;
    public void set(T t) {
      this.t = t;
    }
    public T get() {
      return t;
    }
  }
  static class Phone{}

  public static void main(String[] args) {
    Parcel parcel = new Parcel<Phone>();    // no warnings
    // warning: [unchecked] unchecked call to set(T)
    // as a member of the raw type Parcel
    parcel.set(new Phone());
    // ! CE: incompatible types: Object cannot be converted to Phone
    //! Phone phone = parcel.get();

    // warning: [unchecked] unchecked conversion
    Parcel<Phone> parcel2 = new Parcel();
    parcel2.set(new Phone());       // no warnings
    //! parcel2.set(new String());  // CE: incompatible types
    Phone phone = parcel2.get();    // OK
  }
}

