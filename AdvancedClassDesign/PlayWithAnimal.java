abstract class Animal {
  String name = "???";
  public void printName() {
    System.out.println(name); // fields don't use virtual invocation
  }
}

class Lion extends Animal {
  // @Override    // error: annotation type not applicable to this kind of declaration
  String name = "Leo";
}

public class PlayWithAnimal {
  public static void main(String[] args) {
    Animal animal = new Lion();
    animal.printName(); // ???
  }
}

