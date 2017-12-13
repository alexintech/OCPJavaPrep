import java.util.function.*;
import java.time.*;
import java.util.*;

public class SupplierImpl {
  public static void main(String[] args) {
    Supplier<LocalDate> s1 = LocalDate::now;
    Supplier<LocalDate> s2 = () -> LocalDate.now();

    LocalDate d1 = s1.get();
    LocalDate d2 = s2.get();

    System.out.println(d1);
    System.out.println(d2);

    Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
    ArrayList<String> a1 = s3.get();
    System.out.println(a1);   // []
    System.out.println(s3);   // SupplierImpl$$Lambda$8/1809... it's in memory
                              // lambda is not saved into file
  }
}

