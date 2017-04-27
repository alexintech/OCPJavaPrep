import java.util.*;

public class RemoveArrayListElements {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    Integer age1 = 20;
    Integer age2 = 20;
    list.add(age1);
    list.add(age2);
    System.out.print(list.size() + ":");    // 2:
    age1 = 30;      // assignes another object to the age1 reference
    list.remove(age1);
    System.out.println(list.size());        // 2
  }
}

