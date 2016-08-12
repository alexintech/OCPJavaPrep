package factory.method;

public class WordAppFactory extends AppFactory {
  public App getApp() {
    return new WordProcessor();
  }
}

