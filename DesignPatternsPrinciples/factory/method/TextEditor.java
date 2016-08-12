package factory.method;

public class TextEditor implements App {
  public void open(String filename) {
    System.out.println("Launch TextEditor using " + filename);
  }
}

