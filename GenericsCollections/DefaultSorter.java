import java.util.*;

public class DefaultSorter {
  static class LastError<T> {
    private T lastError;
    void setError(T t) {
      lastError = t;
      System.out.println("LastError: setError");
    }
  }

  static class StrLastError<S extends CharSequence> extends LastError<String> {
    public StrLastError(S s) {
    }
    void setError(S s) {
      System.out.println("StrLastError: setError");
    }
  }

  public static void main(String[] args) {
    String[] brics = {"Brazil", "Russia", "India"};
    Arrays.sort(brics, null);   // won't throw NullPointerException
                                // uses natural order
    System.out.println(Arrays.toString(brics)); // [Brazil, India, Russia]

    "abracadabra".chars().distinct()
      .peek(ch -> System.out.printf("%c ", ch))   // no output
      .sorted();    // no terminal operation, so nothing will be executed

    StrLastError<String> err = new StrLastError<String>("Error");
    err.setError("Last error");   //  error: reference to setError is ambiguous
          // both method setError(T) in LastError and
          // method setError(S) in StrLastError match
          // where T,S are type-variables
  }
}

