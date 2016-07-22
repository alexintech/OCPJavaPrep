class BaseClass {
  public void foo() {
    System.out.println("BaseClass's foo");
  }
}

interface BaseInterface {
  default public void foo() {
    System.out.println("BaseInterface's foo");
  }
}

public class DiamondBaseClass extends BaseClass implements BaseInterface {
  public static void main(String[] args) {
    new DiamondBaseClass().foo();  // BaseClass's foo "class wins" rule
  }
}

