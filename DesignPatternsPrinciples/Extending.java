class OuterA {
  class InnerA { }
}

class SubclassC extends OuterA.InnerA {
  // Mandatory non-default constructor
  SubclassC(OuterA outerRef) {
    outerRef.super();   // explicit super() call
  }
}

class OuterB extends OuterA {
  class InnerB extends OuterB.InnerA { }
}

public class Extending {
  public static void main(String[] args) {
    // Outer instance passed explicitly in constructor call
    new SubclassC(new OuterA());

    // No outer instance passed explicitly in constructor call to InnerB
    new OuterB().new InnerB();
  }
}

