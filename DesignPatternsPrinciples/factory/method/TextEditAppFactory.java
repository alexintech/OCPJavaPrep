package factory.method;

public class TextEditAppFactory extends AppFactory {
  public App getApp() {
    return new TextEditor();
  }
}
