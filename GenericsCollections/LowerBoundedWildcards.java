import java.util.*;
import java.io.*;

public class LowerBoundedWildcards {
  public static void addSound(List<? super String> list) {
    list.add("quack");
    //! list.add(new Object());   // CE: no method for add(Object)
  }

  public static void main(String[] args) {
    List<String> strings = new ArrayList<String>();
    strings.add("tweet");
    List<Object> objects = new ArrayList<Object>(strings);
    addSound(strings);  // OK
    addSound(objects);  // OK

    List<? super IOException> exceptions = new ArrayList<Exception>();
    //! List<? super IOException> exc = new ArrayList<FileNotFoundException>(); //CE
    //! exceptions.add(new Exception());  // CE
    exceptions.add(new IOException());
    exceptions.add(new FileNotFoundException());
  }
}

