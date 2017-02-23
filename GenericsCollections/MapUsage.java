import java.util.*;

public class MapUsage {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("koala", "bamboo");
    map.put("lion", "meat");
    map.put("giraffe", "leaf");
    String food = map.get("koala");   // bamboo
    for (String key : map.keySet())
      System.out.print(key + ",");  // koala,giraffe,lion,

    System.out.println();
    //! System.out.println(map.contains("lion"));   // CE: It's method of Collection
    System.out.println(map.containsKey("lion"));   // true
    System.out.println(map.containsValue("lion")); // false
    System.out.println(map.size());                // 3

    Map<String, String> treeMap = new TreeMap<>();
    treeMap.put("koala", "bamboo");
    treeMap.put("lion", "meat");
    treeMap.put("giraffe", "leaf");
    String food1 = treeMap.get("koala");   // bamboo
    for (String key : treeMap.keySet())
      System.out.print(key + ",");  // giraffe,koala,lion,
  }
}

