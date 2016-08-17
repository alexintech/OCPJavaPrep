class Superclass {
  protected double x = 3.0e+8;
}

class TopLevelClass {
  private double x = 3.14;

  class Inner extends Superclass {
    public void printHidden() {
      System.out.println("this.x: " + x);    // 3.0E8 (from superclass)
      System.out.println("TopLevelClass.this.x: " + TopLevelClass.this.x); // 3.14
    }
  }
}

public class HiddenAndInheritedAccess {
  public static void main(String[] args) {
    TopLevelClass.Inner ref = new TopLevelClass().new Inner();
    ref.printHidden();
  }
}

