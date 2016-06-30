abstract class Animal {
  String name = "???";
  public void printName() {
    System.out.println(name); // fields don't use virtual invocation
  }
}

class Lion extends Animal {
  String name = "Leo";
}

public class PlayWithAnimal {
  public static void main(String[] args) {
    Animal animal = new Lion();
    animal.printName(); // ???
  }
}

