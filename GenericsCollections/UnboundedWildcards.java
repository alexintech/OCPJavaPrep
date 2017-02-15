import java.util.*;

public class UnboundedWildcards {
  public static void printList(List<?> list) {
    for (Object x : list)
      System.out.println(x);
  }
  public static void main(String[] args) {
    List<String> keywords = new ArrayList<>();
    keywords.add("java");
    printList(keywords);

    //! List<Object> objects = keywords;  // CE: incompatible types
    // objects.add(new Integer(3));
    // System.out.println(keywords.get(1));

    List<?> anything = keywords;    // OK
    //! anything.add(new Integer(3)); //  error: no suitable method found for add(Integer)
    //! anything.add((Object)"kotlin");   // CE
    //! anything.add("kotlin");           // CE
    System.out.println(anything.get(0));
  }
}

