public class BridgeMethods {

  static class Book {}

  static class Parcel<T> {
    private T t;
    public void set(T t) {
      this.t = t;
    }
  }

  static class BookParcel extends Parcel<Book> {
    public void set(Book book) {
      super.set(book);
    }
    //! CE: invalide override base method Parsel.set(T)
    // public String set(Object obj) {
    //   return "Hello";
    // }
  }

  public static void main(String[] args) {
    BookParcel bookParcel = new BookParcel();
  }
}

