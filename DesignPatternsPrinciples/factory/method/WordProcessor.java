package factory.method;

public class WordProcessor implements App {
  public void open(String filename) {
    System.out.println("Launch WordProcessor using " + filename);
  }
}

