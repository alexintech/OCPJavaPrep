import java.util.*;

public class BackedCollections {
  public static void main(String[] args) {
    TreeMap<String, String> map = new TreeMap<String, String>();
    map.put("a", "ant");
    map.put("d", "dog");
    map.put("h", "horse");

    SortedMap<String, String> submap;
    submap = map.subMap("b", "g");    // create a backed collection
                                      // {d=dog}

    System.out.println(map + " " + submap);

    map.put("b", "bat");      // {a=ant, b=bat, d=dog, h=horse}
                              // {b=bat, d=dog}
    submap.put("f", "fish");  // {a=ant, b=bat, d=dog, f=fish, h=horse}
                              // {b=bat, d=dog, f=fish}
    // not added to backed collection - out of range
    map.put("r", "raccoon");  // {a=ant, b=bat, d=dog, f=fish, h=horse, r=raccoon}
                              // {b=bat, d=dog, f=fish}
    //! submap.put("p", "pig");   // throws IllegalArgumentException - key out of range

    System.out.println(map + " " + submap);

    // removes from both maps
    ((NavigableMap<String, String>)submap).pollFirstEntry();
    System.out.println(map + " " + submap);
    // {a=ant, d=dog, f=fish, h=horse, r=raccoon} {d=dog, f=fish}

    // removes only from the original map
    map.pollFirstEntry();
    System.out.println(map + " " + submap);
    // {d=dog, f=fish, h=horse, r=raccoon} {d=dog, f=fish}
  }
}

