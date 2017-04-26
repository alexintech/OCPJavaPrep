public class GenericInheritence {
  class Book {}
  class Phone {}

  class Parcel<T> { }
  class GenericBookParcel<T> extends Parcel<T> {} // OK
  //! class GenericPhoneParcel<X> extends Parcel<T> {} // CE: type argument
        // must be passed to base class
  class GenericPhoneParcel2<X, T> extends Parcel<T> {}    // OK
  class GenericBookParcel2<X> extends Parcel<Book> {}     // OK

  class NonGenericPhoneParcel extends Parcel<Phone> {}    // OK

  interface MyMap<K, V> {
    void put(K key, V value);
    V get(K key);
  }
  class MapLegendGeneric<V> implements MyMap<String, V> {
    public void put(String key, V value) {}
    public V get(String key) { return null; }
  }

  public static void main(String[] args) {
    //! NonGenericPhoneParcel<String> var =
    //!    new NonGenericPhoneParcel<>();    // CE: it's not a generic class
  }
}

