import java.util.*;
import java.util.function.*;

public class CollectionsNewAPI {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Magician");
    list.add("Assistant");
    System.out.println(list);   // [Magician, Assistant]
    list.removeIf(s -> s.startsWith("A"));
    System.out.println(list);   // [Magician]

    List<Integer> list2 = Arrays.asList(1, 2, 3);
    list2.replaceAll(x -> x*2);
    System.out.println(list2);  // [2, 4, 6]

    List<String> cats = Arrays.asList("Annie", "Ripley");
    cats.forEach(c -> System.out.println(c));
    cats.forEach(System.out::println);    // Annie
                                          // Ripley

    Map<String, String> favorites = new HashMap<>();
    favorites.put("Jenny", "Bus Tour");
    favorites.put("Tom", null);

    favorites.putIfAbsent("Jenny", "Tram");   // returns Bus Tour
    favorites.putIfAbsent("Sam", "Tram");     // returns null
    favorites.putIfAbsent("Tom", "Tram");     // returns null
    System.out.println(favorites);  // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}

    BiFunction<String, String, String> mapper = (v1, v2)
      -> v1.length() > v2.length() ? v1 : v2;
    BiFunction<String, String, String> mapper2 = (v1, v2) -> null;

    Map<String, String> favorites2 = new HashMap<>();
    favorites2.put("Jenny", "Bus Tour");
    favorites2.put("Tom", "Tram");
    favorites2.put("Sam", null);
    favorites2.put("Jimmy", "Bus Tour");

    String jenny = favorites2.merge("Jenny", "Skyride", mapper);
    String tom = favorites2.merge("Tom", "Skyride", mapper);
    String sam = favorites2.merge("Sam", "Skyride", mapper);  // mapper is not
            // called. No NullPointerException
    String jimmy = favorites2.merge("Jimmy", "Skyride", mapper2);
    String joe = favorites2.merge("Joe", "Skyride", mapper2);

    System.out.println(favorites2);
    // {Joe=Skyride, Tom=Skyride, Jenny=Bus Tour, Sam=Skyride}
    System.out.println(jenny);      // Bus Tour
    System.out.println(tom);        // Skyride
    System.out.println(sam);        // Skyride
    System.out.println(jimmy);      // null
    System.out.println(joe);        // Skyride
  }
}

