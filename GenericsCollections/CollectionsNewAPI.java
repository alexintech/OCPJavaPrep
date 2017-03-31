import java.util.*;

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
  }
}

