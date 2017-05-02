import java.util.*;

public class GenericUsage {
  public static void main(String[] args) {
    String[] myArray = {"Harry", "Shreya", "Selvan", "Paul"};

    List<?> myArrayList1 = new LinkedList<>(Arrays.asList(myArray));
    List<? extends String> myArrayList2 = new LinkedList<>(Arrays.asList(myArray));

    // generates warning
    List myArrayList3 = new LinkedList(Arrays.asList(myArray));

    List myArrayList4 = new LinkedList<String>(Arrays.asList(myArray));

  }
}

