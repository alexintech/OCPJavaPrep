package factory.method;

public class Client {
  public static void main(String[] args) {
    AppFactory factory = new WordAppFactory();
    App app = factory.getAppInstance();
    app.open("Hello.doc");

    app = new TextEditAppFactory().getAppInstance();
    app.open("Hello.xml");
  }
}

